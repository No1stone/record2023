package com.example.redisinittest.config;

import com.example.redisinittest.biz.service.RedisMessgeStringSubscriber;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import javax.crypto.KeyGenerator;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class RedisConfig implements CachingConfigurer{

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

    @Override
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager() {

            @Override
            protected Cache createConcurrentMapCache(final String name) {
                return new ConcurrentMapCache(name,
                        CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).maximumSize(100).build().asMap(), false);
//            캐시빌더 구글 구아바스펙.
            }
        };

        return cacheManager;
    }


}
