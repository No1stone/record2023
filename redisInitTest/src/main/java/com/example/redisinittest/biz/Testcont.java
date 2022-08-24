package com.example.redisinittest.biz;

import com.example.redisinittest.db.redis.entity.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Testcont {

    private final TestService testService;

    @GetMapping(path = "/test1")
    public void Test1(){
        log.info("test1");
            testService.saveTest();
    }

    @GetMapping(path = "/test2/{id}")
    public Person test2(@PathVariable(name = "id")String id){
        log.info("test id = {}", id);
        return testService.getId(id);
    }

    @GetMapping(path = "/test3")
    public void test3(){
        testService.test3();
    }

    @Value("${value.data1}")
    private String data1;

    @GetMapping(path="/test4")
    public void test4(){
        log.info(data1);
    }

}
