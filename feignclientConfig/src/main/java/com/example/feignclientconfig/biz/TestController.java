package com.example.feignclientconfig.biz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestFeignClient client;

    @GetMapping(path ="/test1")
    public void test1 (){

        log.info("test1 init");
       String a =  client.getTest("feign data");
       log.info("result data - {}",a);
    }

    @GetMapping(path = "/test2")
    public void test2(){

        log.info("feign Test2 init");
        TestBody tb = new TestBody();
        tb.setTest1("1");
        tb.setTest2("2");
        tb.setTest3("3");

       String test2re = client.getTest2(tb);
       log.info("return data - {}", test2re);
    }
}
