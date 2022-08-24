package com.jws.wonseok.config.filter;

import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@RequiredArgsConstructor
public class Webconfig implements WebMvcConfigurer {


    private final HandlerInterceptor authInterceptor;
    private final Logger logger = LoggerFactory.getLogger(Webconfig.class);

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor)
//                .addPathPatterns("/V1/account/**")
//                .addPathPatterns("/V1/company/**")
//                .addPathPatterns("/V1/passport/**")
//                .addPathPatterns("/**")
//                .addPathPatterns("/V1/sns/**")
//                .excludePathPatterns("account/swagger-ui/**")
//                .excludePathPatterns("account/V1/signUp/**")
//                .excludePathPatterns("/**")
//        ;
//    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*");
//    }

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        HttpClient client = HttpClientBuilder.create()
                .setMaxConnTotal(50)
                .setMaxConnPerRoute(20).build();
        factory.setHttpClient(client);
        factory.setConnectTimeout(10000);
        factory.setReadTimeout(5000);

        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Value("${security.jwt.token.secret-key}")
//    private String jwt;

//    @Bean
//    public UserInfoDTO UserinfoBean() {
////        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
////        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
////        dispatcherServlet.setThreadContextInheritable(true);
//        logger.info("넌 실행 되니?");
//        if(RequestContextHolder.getRequestAttributes() == null){
//            return UserInfoDTO.builder().build();
//        }
//
//         HttpServletRequest
//                 request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        logger.info("넌 실행 되니?");
//        Gson gson = new Gson();
//        String reqAuthorization = request.getHeader("Authorization");
//        logger.info("reqAuthorization - {}",reqAuthorization);
//        String token = reqAuthorization.trim().substring(6);
//        logger.info("token - {}",token);
//        String sub = Jwts.parserBuilder()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(jwt))
//                .build()
//                .parseClaimsJws(token)
//                .getBody().getSubject();
//        UserInfoDTO userInfoDTO = gson.fromJson(sub, UserInfoDTO.class);
//        logger.info("userInfoDTO - {}",userInfoDTO);
//        request.setAttribute("UserInfoDTO",userInfoDTO);
//        return  userInfoDTO;
//    }

}