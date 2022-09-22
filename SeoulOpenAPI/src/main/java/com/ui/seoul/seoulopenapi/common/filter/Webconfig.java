package com.ui.seoul.seoulopenapi.common.filter;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class Webconfig implements WebMvcConfigurer {

    private final HandlerInterceptor authInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/V1/profile/**")
                .excludePathPatterns("account/swagger-ui/**")
        ;
    }

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

}