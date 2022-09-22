package com.jws.wonseok.config.filter.responsepack;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Properties;

@EnableAsync
@Configuration
@RequiredArgsConstructor
public class CommonConfig {


	final int slidersCount=10;
	final Environment environment;

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/message/code/code", "classpath:/message/code");
		messageSource.setDefaultEncoding("UTF-8");
//		messageSource.setCacheMillis(-1);
		messageSource.setCacheMillis(3);
		messageSource.setUseCodeAsDefaultMessage(true);

		return messageSource;
	}

	@Bean
	public MessageSourceAccessor messageSourceAccessor() {
		MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(messageSource());
		return messageSourceAccessor;
	}


//	@Bean
////request로 넘어오는 language parameter를 받아서 locale로 설정 한다.
//	public LocaleChangeInterceptor localeChangeInterceptor(){
//		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//
//		localeChangeInterceptor.setParamName("lang");
//localhost:8080~?lang=ko 이런식으로 받아오는 파라미터 키 정의

	//한국 기준 메시지 요청 사용법
	//String korMessage = messageSource.getMessage("com.title",null, "no search", Locale.KOREA);
//		return localeChangeInterceptor;
//	}


	@Bean(name = "system")
	@ConfigurationProperties(prefix="system")
	public Properties system(){
		return new Properties();
	}


//	@Bean
//	public FilterRegistrationBean encodingFilterBean() {
//		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//		CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
//		filter.setForceEncoding(true);
//		filter.setEncoding("UTF-8");
//		registrationBean.setFilter(filter);
//		registrationBean.addUrlPatterns("/*");
//		return registrationBean;
//	}
//
//	@Bean(name = "threadPoolTaskExecutor")
//	public Executor threadPoolTaskExecutor()
//	{
//		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
//		taskExecutor.setCorePoolSize(3);	//init  pool size
//		taskExecutor.setMaxPoolSize(30);	//max  pool size
//		//기본 값 : Integer.MAX_VALUE , MaxPoolSize 로 처리가 불가능 할때 Queue를 사용
//		//taskExecutor.setQueueCapacity(Integer.MAX_VALUE);
//		taskExecutor.initialize();
//		return taskExecutor;
//	}

}
