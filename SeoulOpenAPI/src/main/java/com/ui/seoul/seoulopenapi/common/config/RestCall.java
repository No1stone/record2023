package com.ui.seoul.seoulopenapi.common.config;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestCall {

    private final Logger logger = LoggerFactory.getLogger(RestCall.class);

    public static void post(String requestURL, String jsonMessage) {

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost postRequest = new HttpPost(requestURL); //POST 메소드 URL 새성
            postRequest.setHeader("Accept", "application/json");
            postRequest.setHeader("Connection", "keep-alive");
            postRequest.setHeader("Content-Type", "application/json");
            //postRequest.addHeader("Authorization", token); // token 이용시

            postRequest.setEntity(new StringEntity(jsonMessage)); //json 메시지 입력

            HttpResponse response = client.execute(postRequest);

            //Response 출력
            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);
                System.out.println(body);
            } else {
                System.out.println("response is error : " + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e){
            System.err.println(e.toString());
        }
    }
    public static Object get(String requestURL){
        Object result = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet getRequest  = new HttpGet(requestURL);
            HttpResponse response = client.execute(getRequest);
            System.out.println(response);
            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);
                System.out.println(body);
                result = body;
            } else {
                System.out.println("response is error : " + response.getStatusLine().getStatusCode());
            }
        }
        catch  (Exception e){
            System.err.println(e.toString());
        }
        return result;
    }

}
