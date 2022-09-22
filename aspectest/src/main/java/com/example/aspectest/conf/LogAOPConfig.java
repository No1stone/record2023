package com.example.aspectest.conf;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@Aspect
public class LogAOPConfig {

//    @Around("execution(* com.example.aspectest.biz..*(..))")
//    public void logi(){
//        log.info("ASPECT  log");
//    }

}
