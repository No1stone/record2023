package com.example.awssdktest.biz;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
