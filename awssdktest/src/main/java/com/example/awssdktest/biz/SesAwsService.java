package com.example.awssdktest.biz;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SesAwsService {

    @Autowired
    private AmazonSimpleEmailService ases;

    public void AuthEmail(String TO, String FROM, String TEXTBODY, String SUBJECT) {
        SendEmailRequest ser = new SendEmailRequest().withDestination(new Destination().withToAddresses(TO))//받는사람
                .withMessage(new Message()
                        .withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(TEXTBODY)))
                        .withSubject(new Content().withCharset("UTF-8").withData(SUBJECT)))
                .withSource(FROM);//보내는놈
        ases.sendEmail(ser);

    }
    public void TempleateSendEmail(String[] to, String from, String temBody, String subject) {
        SendEmailRequest ser = new SendEmailRequest().withDestination(new Destination().withToAddresses(to))//받는사람
                .withMessage(new Message()
                        .withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(temBody)))
                        .withSubject(new Content().withCharset("UTF-8").withData(subject)))
                .withSource(from);//보내는놈
        ases.sendEmail(ser);
    }
    public void TextSendMail(String[] TO, String FROM, String TEXT, String SUBJECT) {
        SendEmailRequest ser = new SendEmailRequest().withDestination(new Destination().withToAddresses(TO))//받는사람
                .withMessage(new Message()
                        .withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(TEXT)))
                        .withSubject(new Content().withCharset("UTF-8").withData(SUBJECT)))
                .withSource(FROM);//보내는놈
        ases.sendEmail(ser);
    }
    public void ArrayfromSendMail(String[] emailTO, String FROM, String TEXT, String SUBJECT) {
        //emailTO 배열형태도되고 emailTo[0],emailTo[1] 이거도됨
        SendEmailRequest ser = new SendEmailRequest().withDestination(new Destination().withToAddresses(emailTO))//받는사람
                .withMessage(new Message()
                        .withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(TEXT)))
                        .withSubject(new Content().withCharset("UTF-8").withData(SUBJECT)))
                .withSource(FROM);//보내는놈
        ases.sendEmail(ser);
        log.info("ser - {}", new Gson().toJson(ser));
    }

}
