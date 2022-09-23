package com.example.feignclientconfig.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.apache.coyote.RequestGroupInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestFeignConfig {

    @Bean
    public Logger.Level FeignLevel(){
    return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("accept", "application/json");
        };
    }

}
