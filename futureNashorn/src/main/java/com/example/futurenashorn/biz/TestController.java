package com.example.futurenashorn.biz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final TestService testService;

    @GetMapping("/test1")
    public void test1() throws ExecutionException, InterruptedException, TimeoutException {
        testService.test1();
    }


    @GetMapping("/test2")
    public void test2() throws ExecutionException, InterruptedException, TimeoutException {
        testService.test2();
    }
}
