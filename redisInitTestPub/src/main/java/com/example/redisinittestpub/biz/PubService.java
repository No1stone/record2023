package com.example.redisinittestpub.biz;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PubService  {

    private final RedisTemplate<String, String> redisTemplate;

    public void sendRedisTemplate(String val) {

        redisTemplate.convertAndSend("ch01", val)
        ;
    }

}
