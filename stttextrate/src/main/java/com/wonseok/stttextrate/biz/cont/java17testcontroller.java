package com.wonseok.stttextrate.biz.cont;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class java17testcontroller {


    @GetMapping("/test1")
    public String test1(){
        return "java 17 boot 3.0 test";
    }

}
