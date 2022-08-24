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
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class SNSAwsService {


    @Autowired
    private AmazonSNS amazonSNS;


    @Value("${sparwk.node.schema}")
    private String schema;


    public void MobileVerifySendService(String phoneNumber, HttpServletRequest req) {

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

        sendSMSMessage(sb.toString(), phoneNumber, smsAttributes);
    }

    public void sendSMSMessage(String message, String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {
        PublishResult result =
                amazonSNS.publish(new PublishRequest()
                        .withMessage(message)
                        .withPhoneNumber(phoneNumber)
                        .withMessageAttributes(smsAttributes));
        System.out.println(result); // result ex) {MessageId: 7ace45e4-31wr-5353-b2f2-17759c45d913} }
    }


}
