package com.example.controlleradvice.controller;

import com.example.controlleradvice.controller.cus.cus1;
import com.example.controlleradvice.controller.cus.cus2;
import com.example.controlleradvice.controller.cus.cus3;
import com.example.controlleradvice.controller.cus.cus5;
import com.example.controlleradvice.controller.testvo.VoRe;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ExController {

    @GetMapping(path = "/test1/{ex}")
    public void test1(@PathVariable(name = "ex") String ex){

        if(ex.equals("ex1")){
            throw new RuntimeException();
        }

        if(ex.equals("ex2")){
            throw new cus1();
        }

        if(ex.equals("ex3")){
            throw new cus2();
        }

        if(ex.equals("ex4")){
            throw new cus3();
        }
        if(ex.equals("ex5")){
            throw new cus5();
        }

    }

    @GetMapping(path = "/test2")
    public void test2(VoRe voRe){
    log.info("a {}", voRe.getA());
    log.info("a {}", voRe.getB());
    log.info("a {}", voRe.getC());
    log.info("a {}", voRe.getD());
    }

}
