package com.example.feignclient.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localghost:8014")
public interface DemoClient {

    @GetMapping("demo")
    String getDemo();

}
