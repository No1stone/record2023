package com.example.feignclientconfig.biz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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


}
