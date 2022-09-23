package com.example.feignclient.config;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class feignConfig {

    @Bean
    public Contract feignContract() {
        log.info("feign contract init");
        return new Contract.Default();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        log.info("Basic Auth Interceptor add");
        return new BasicAuthRequestInterceptor("user","password");
    }

}
