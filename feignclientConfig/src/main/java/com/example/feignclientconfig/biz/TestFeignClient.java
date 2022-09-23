package com.example.feignclientconfig.biz;

import com.example.feignclientconfig.config.TestFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "testFeignClient", url = "http://localhost:8014", configuration = TestFeignConfig.class)
public interface TestFeignClient {

    @GetMapping("/test1")
    String getTest(@RequestParam("a")String a);

    @PostMapping("/test2")
    String getTest2(@RequestBody TestBody testBody);
}
