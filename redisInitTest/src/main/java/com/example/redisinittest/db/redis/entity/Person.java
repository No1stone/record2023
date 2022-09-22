package com.example.redisinittest.db.redis.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@RedisHash(value = "people", timeToLive = 60*60*30*7)
public class Person {


    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDateTime createdAt;
    public Person(String id, String name, Integer age, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createdAt = createdAt;
    }


}
