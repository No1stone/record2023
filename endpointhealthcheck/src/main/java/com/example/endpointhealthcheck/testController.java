package com.example.endpointhealthcheck;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class testController {

    @GetMapping(path = "/test1")
    public void getHeaders(@RequestHeader Map<String, String> headers){
        log.info("datas - {}", headers);
    }

}
