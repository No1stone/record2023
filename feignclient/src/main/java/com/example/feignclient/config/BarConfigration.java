package com.example.feignclient.config;

import feign.Feign;
import feign.Target;
import org.springframework.cloud.openfeign.CircuitBreakerNameResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Method;

@Configuration
public class BarConfigration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder(){
        return new Feign.Builder();
    }

    @Bean
    public CircuitBreakerNameResolver circuitBreakerNameResolver() {
        return (String feignClientName, Target<?> target, Method method) -> feignClientName + "_" + method.getName();
    }

}
