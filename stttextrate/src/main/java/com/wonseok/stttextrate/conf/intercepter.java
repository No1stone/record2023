package com.wonseok.stttextrate.conf;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//@Component
@Slf4j
public class intercepter implements HandlerInterceptor {



    /**
     * Create a new WebRequestHandlerInterceptorAdapter for the given WebRequestInterceptor.
     *
     * @param requestInterceptor the WebRequestInterceptor to wrap
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("init");
        if (request.getMethod().equals("OPTIONS")) {
            log.info("true");
            //CORS인증 유효 처리를 위해
            return true;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
