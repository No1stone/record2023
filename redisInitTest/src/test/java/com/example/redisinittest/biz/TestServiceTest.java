package com.example.redisinittest.biz;

import com.example.redisinittest.db.redis.entity.Person;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;

@SpringBootTest(properties = {
        "spring.config.location=classpath:application.yml"})
class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    @DisplayName("ServiceTest1")
    public void TestService1(){
        Person result = testService.getId("token1");

        assertEquals(result.getId(),"token1");
        assertNotNull(result.getId());
//        assertThat();
    }
}