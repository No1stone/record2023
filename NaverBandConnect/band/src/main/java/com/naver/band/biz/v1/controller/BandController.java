package com.naver.band.biz.v1.controller;

import com.naver.band.biz.v1.method.BandURL;
import com.naver.band.biz.v1.model.type.BandURLType;
import com.naver.band.biz.v1.service.BandService;
import com.naver.band.common.util.RestCall;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class BandController {

    private final Logger logger = LoggerFactory.getLogger(BandController.class);
    private final BandService bandService;

    @Value("${naver.band.client.id}" )
    private String clientId;
    @Value("${naver.band.client.code}" )
    private String clientCode;
    @Value("${naver.band.client.secret}" )
    private String clientSecret;
    @Value("${naver.band.accessToken}" )
    private String accessToken;

    @GetMapping(path = "/test" )
    public void authorizationController(@RequestParam(name = "code" ) String code) {
        logger.info("승인되면 토큰을 받음 = {}", code);
        String urlll = BandURL.builder()
                .schema(BandURLType.http.getS())
                .baseURL(BandURLType.BaseURL.getS())
                .api(BandURLType.AuthToken.getS())
                .param("grant_type", "authorization_code")
                .param("code", code)
                .build();

        String en64en = Base64.getEncoder().encodeToString((clientId+":"+clientSecret).getBytes(StandardCharsets.UTF_8));
        logger.info("en64 - {}",en64en);
        Object result = RestCall.getSetHeader(urlll, en64en);
        logger.info("testresult", urlll);
        logger.info( "result - {}",result);
    }

    @GetMapping(path = "/testb" )
    public String authorizationControllerb() {
        //FULL URL 입력
        String enURL = URLEncoder.encode("http://c208-121-66-45-243.ngrok.io/test", Charset.forName("UTF-8" ));
        logger.info(enURL);
        logger.info(URLDecoder.decode(enURL, Charset.forName("UTF-8" )));
        String urlll = BandURL.builder()
                .schema(BandURLType.http.getS())
                .baseURL(BandURLType.BaseURL.getS())
                .api(BandURLType.apiPath.getS())
                .param("response_type", "code")
                .param("client_id", clientId)
                .param("redirect_uri", enURL)
                .build();

        logger.info("urlllllll ====== {}",urlll);
        RestCall.get(urlll);
        return urlll;
    }

    @GetMapping(path = "/testc")
    public String UserInfoGet(){
        String urlll = BandURL.builder()
                .schema(BandURLType.http.getS())
                .baseURL(BandURLType.BaseURL.getS())
                .api(BandURLType.apiPath.getS())
                .param("grant_type", "authorization_code")
                .param("code", "ZQAAAajSvSA_7MCs6Y_WmewGRY_-G5WbdoqH5nRF-0v0sA9_EopCWuoYCNiHGyPLSAwX7hphrAabNbwa4g47T82albq1O7FsceAHfsKU4UB6DMq4")
                .build();


        String en64en = Base64.getEncoder().encodeToString((clientId+":"+clientSecret).getBytes(StandardCharsets.UTF_8));
        Object result = RestCall.getSetHeader(urlll, en64en);
        logger.info(urlll);
        logger.info( "result - {}",result);
        return urlll;
    }


}
