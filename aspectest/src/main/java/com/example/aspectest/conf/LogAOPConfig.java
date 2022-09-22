package com.example.aspectest.conf;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@Configuration
@Slf4j
@Aspect
@RequiredArgsConstructor
public class LogAOPConfig {

    private final HttpServletRequest httpServletRequest;

    @Around("execution(* com.example.aspectest.biz..*(..))")
    public Object logi(ProceedingJoinPoint joinPoint) throws Throwable {

        //return void 하면 컨트롤러에 안들어감.

        log.info("ASPECT  log");
        log.info("aspect request http - {}", new Gson().toJson(httpServletRequest.getContextPath()));
        log.info("aspect request http - {}", new Gson().toJson(httpServletRequest.getMethod()));
        log.info("aspect getRequestURI http - {}", new Gson().toJson(httpServletRequest.getRequestURI()));
        log.info("aspect getRequestURL http - {}", new Gson().toJson(httpServletRequest.getRequestURL()));
        log.info("aspect ParameterMap http - {}", new Gson().toJson(httpServletRequest.getParameterMap()));
        log.info("aspect getRemoteHost http - {}", new Gson().toJson(httpServletRequest.getRemoteHost()));
        log.info("aspect getQueryString http - {}", new Gson().toJson(httpServletRequest.getQueryString()));
        log.info("aspect getQueryString http - {}", new Gson().toJson(httpServletRequest.getReader().lines().collect(Collectors.joining())));

//        ContentCachingRequestWrapper war = (ContentCachingRequestWrapper) httpServletRequest;
//        log.info("aspect getQueryString http - {}", new Gson().toJson(war.getContentAsByteArray()));


        Object result = joinPoint.proceed();

        log.info("aspect joinpoint - {}", new Gson().toJson(result));
        return joinPoint;

    }

}
