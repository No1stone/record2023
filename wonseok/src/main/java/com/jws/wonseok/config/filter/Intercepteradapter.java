package com.jws.wonseok.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Intercepteradapter implements HandlerInterceptor {

    @Value("${security.jwt.token.secret-key}")
    private String jwt;
    /*
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
*/
    private final Logger logger = LoggerFactory.getLogger(Intercepteradapter.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
//        if (request.getMethod().equals("OPTIONS")) {
//            //CORS인증 유효 처리를 위해
//            return true;
//        }
//        Gson gson = new Gson();
//        String reqAuthorization = request.getHeader("Authorization");
//        logger.info("reqAuthorization - {}",reqAuthorization);
//        String token = reqAuthorization.trim().substring(6);
//        logger.info("token - {}",token);
////        String sub = tokenDecoding.getSubject(token);
//        UserInfoDTO userInfoDTO = gson.fromJson(sub, UserInfoDTO.class);
//        logger.info("userInfoDTO - {}",userInfoDTO);
//        request.setAttribute("UserInfoDTO",userInfoDTO);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
