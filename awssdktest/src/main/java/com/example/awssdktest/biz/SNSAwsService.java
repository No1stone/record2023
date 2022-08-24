package com.example.awssdktest.biz;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.google.gson.Gson;
import com.sparwk.externalconnectnode.mailing.biz.v1.dto.AccountResponse;
import com.sparwk.externalconnectnode.mailing.biz.v1.dto.AdminEmailSendRequest;
import com.sparwk.externalconnectnode.mailing.config.common.VerifyNumber;
import com.sparwk.externalconnectnode.mailing.config.filter.responsepack.Response;
import com.sparwk.externalconnectnode.mailing.config.filter.responsepack.ResultCodeConst;
import com.sparwk.externalconnectnode.mailing.config.filter.token.UserInfoDTO;
import com.sparwk.externalconnectnode.mailing.jpa.dto.MediaVerifyBaseDTO;
import com.sparwk.externalconnectnode.mailing.jpa.entity.MediaVerify;
import com.sparwk.externalconnectnode.mailing.jpa.repository.MediaVerifyRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SNSAwsService {

    private final Logger logger = LoggerFactory.getLogger(SNSService.class);

    @Autowired
    private AmazonSNSClient amazonSNSClient;
    @Autowired
    private AmazonSNS amazonSNS;
    @Autowired
    private SESServiceRepository sesServiceRepository;

    @Autowired
    private MediaVerifyRepository mediaVerifyRepository;

    private final MessageSourceAccessor messageSourceAccessor;

    @Value("${sparwk.node.schema}")
    private String schema;
    @Value("${sparwk.node.personalization.accountip}")
    private String accountIp;

    @Autowired
    private RestTemplate restTemplate;

    public Response MobileVerifySendService(String phoneNumber, HttpServletRequest req) {
        UserInfoDTO userInfoDTO = (UserInfoDTO) req.getAttribute("UserInfoDTO");
        logger.info("userInfoDTO", userInfoDTO.getAccountId());

        String verifyNumberString = VerifyNumber.verifyNumber();
        Map<String, MessageAttributeValue> smsAttributes = new HashMap<>();
        smsAttributes
                .put("AWS.SNS.SMS.SenderID", new MessageAttributeValue()
                        .withStringValue("mySenderId").withDataType("String"));

        smsAttributes
                .put("AWS.SNS.SMS.MaxPrice", new MessageAttributeValue()
                        .withStringValue("0.50").withDataType("String"));

        smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
                .withStringValue("Promotional").withDataType("String"));

        StringBuffer sb = new StringBuffer();
        sb.append("Sparwk 핸드폰 인증번호는[");
//        sb.append("Verification code for Spark is [");

        sb.append(verifyNumberString);
        sb.append("]입니다");
//        sb.append("]");


        MediaVerify saveResult = sesServiceRepository
                .MobileLogSave(userInfoDTO.getAccountId(), phoneNumber, verifyNumberString);

        sendSMSMessage(sb.toString(), phoneNumber, smsAttributes);
        Response res = new Response();
        res.setResultCd(ResultCodeConst.SUCCESS.getCode());
        res.setResultMsg(messageSourceAccessor.getMessage(res.getResultCd()));
        return res;
    }

    public void sendSMSMessage(String message, String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {
        PublishResult result =
                amazonSNS.publish(new PublishRequest()
                        .withMessage(message)
                        .withPhoneNumber(phoneNumber)
                        .withMessageAttributes(smsAttributes));
        System.out.println(result); // result ex) {MessageId: 7ace45e4-31wr-5353-b2f2-17759c45d913} }
    }

    public Response MobileVerifyReciveService(String number, HttpServletRequest req) {
        UserInfoDTO userInfoDTO = (UserInfoDTO) req.getAttribute("UserInfoDTO");
        logger.info("userInfoDTO", userInfoDTO.getAccountId());
        Response res = new Response();
        res.setResultCd(ResultCodeConst.BAD_REQUEST.getCode());
        res.setResultMsg(messageSourceAccessor.getMessage(res.getResultCd()));
        int count = mediaVerifyRepository.countByAccntIdAndMediaValidStringAndMediaTypeCd(userInfoDTO.getAccountId(), number, "Mobile");
        logger.info("count ------ {}", count);
        if (count > 0) {
            MediaVerifyBaseDTO selectResult = sesServiceRepository.MobileLogSelect(userInfoDTO.getAccountId(), number);
            if (selectResult.getExpiredDt().plusMinutes(3).isBefore(LocalDateTime.now())) {
                res.setResultCd(ResultCodeConst.VERIFY_TIME_OVER.getCode());
                res.setResultMsg(messageSourceAccessor.getMessage(res.getResultCd()));
                return res;
            }
            if (selectResult.getMediaValidString().equals(number)) {
                logger.info("account send init ------ ");
                AccountResponse accountResponse = AccountResponse.builder()
                        .accntId(userInfoDTO.getAccountId())
                        .phoneNumber(selectResult.getMediaVerifyReqId())
                        .verifyPhoneYn("Y")
                        .build();

                //인증성공 핸드폰 와이엔 업데이트 소스 넣기
                HttpHeaders headers = new HttpHeaders();
                String bearertoken = req.getHeader("Authorization");
                logger.info("token", bearertoken);
                String token = bearertoken.substring(7);
                StringBuffer sb = new StringBuffer();
                sb.append("Bearer ");
                sb.append(token);
                headers.set("Authorization", sb.toString());
                UriComponentsBuilder builder =
                        UriComponentsBuilder
                                .newInstance()
                                .scheme(schema)
                                .host(accountIp)
                                .path("V1/account/info/update");
                UriComponents uriComponents = builder.build();
                logger.info("accountLast profile tostring - {}", uriComponents.toString());
                HttpEntity<AccountResponse> entity = new HttpEntity<>(accountResponse, headers);
//        ResponseEntity<String> tokenResponse =
//                restTemplate.exchange(uriComponents.toUriString(), HttpMethod.POST, entity, String.class);
                ResponseEntity<String> resultResponse =
                        restTemplate.postForEntity(uriComponents.toUriString(), entity, String.class);
                JSONObject obj = new JSONObject(resultResponse.getBody());
                logger.info("object - {}", obj.toString());

                Gson gson = new Gson();
                Response responseAccount = gson.fromJson(String.valueOf(obj), Response.class);
                logger.info("-------- {}", responseAccount.getResultCd());

                res.setResultCd(ResultCodeConst.SUCCESS.getCode());
                res.setResultMsg(messageSourceAccessor.getMessage(res.getResultCd()));
                return res;
            } else {
                res.setResultCd(ResultCodeConst.VERIFY_NUMBER_FAIL.getCode());
                res.setResultMsg(messageSourceAccessor.getMessage(res.getResultCd()));
                return res;
            }

        } else {
            res.setResultCd(ResultCodeConst.NOT_FOUND_INFO.getCode());
            res.setResultMsg(messageSourceAccessor.getMessage(res.getResultCd()));
            return res;
        }


    }


    public <T> void POSTBasicTemplate(String schema, String host, String path, AdminEmailSendRequest entity) {

        schema = "http";
        host = "192.168.0.42:8120/mailing";
        path = "/V1/admin/send";
        HttpHeaders headers = new HttpHeaders();
        UriComponentsBuilder builder =
                UriComponentsBuilder
                        .newInstance()
                        .scheme(schema)// http & https
                        .host(host) //localhost:8080
                        .path(path); //V1/profile/info
        UriComponents uriComponents = builder.build();
        logger.info("URI COMPONENT tostring - {}", uriComponents.toString());
        HttpEntity<AdminEmailSendRequest> responsEntity = new HttpEntity<>(entity, headers);
        ResponseEntity<String> resultResponse =
                restTemplate.postForEntity(uriComponents.toUriString(), responsEntity, String.class);
        JSONObject obj = new JSONObject(resultResponse.getBody());
        logger.info("object - {}", obj.toString());
        Gson gson = new Gson();
        Response response = gson.fromJson(String.valueOf(obj), Response.class);
        logger.info("--------Respoonse {}", response.getResultCd());
    }

}
