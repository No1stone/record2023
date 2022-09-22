package com.example.redisinittest.biz.service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisMessgeStringSubscriber implements MessageListener {


    @Override
    public void onMessage(Message message, byte[] pattern) {

        log.info("Redis Subscriber");
        log.info("Redis Subscriber -{}", new Gson().toJson(message));
        log.info("Redis Subscriber -{}", message.toString());
    }
}
