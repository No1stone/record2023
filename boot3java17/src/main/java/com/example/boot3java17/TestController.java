package com.example.boot3java17;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final TestService testService;

    @GetMapping("/test1")
    public String test1(){
        return "java17 boot3.0 build test";
    }
    @GetMapping("/test2")
    public String test2(){
        return testService.test2();
    }
    @GetMapping("/test3")
    public Map test3(){
        return testService.test3();
    }
    @GetMapping("/test4")
    public String test4(){
        return testService.test4();
    }
    @GetMapping("/test5")
    public String test5(){
        return testService.test5();
    }
    @GetMapping("/test6")
    public String test6(){
        return testService.test6();
    }



}
