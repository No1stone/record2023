package com.example.redisinittest.config;

import com.example.redisinittest.biz.service.RedisMessgeStringSubscriber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
@EnableCaching
public class RedisConfig {

    /**
     * @EnableCaching 캐싱 기능을 사용
     * @Cacheable(value="test") 캐싱을 추가하는 메소드에 붙힌다.
     * @CacheEvict(value="test") 캐싱을 처리하고 캐쉬를 삭제할 메소드에 붙힌다.
     * @CachePut(value="test") 캐싱을 처리하고 캐쉬를 수정할 메소드에 붙힌다.
     * @Cachㅑㅜㅎ(value="test") 여러개를 처리할때 사용한다.
     */

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(host, port);
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory());
        container.addMessageListener(messageListenerAdapter(), topic());
        return container;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(){
        return new MessageListenerAdapter(new RedisMessgeStringSubscriber());
    }

    @Bean
    public ChannelTopic topic(){
        return new ChannelTopic("ch01");
    }

}
