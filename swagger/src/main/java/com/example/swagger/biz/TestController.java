package com.example.swagger.biz;

import com.example.swagger.biz.model.UserReq;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = {"TEST Controller 1"})
public class TestController {

    /**
     * https://springfox.github.io/springfox/docs/current/#springfox-swagger-ui
     *
     */

    @Operation(
//            tags = {"겟보이드"},
            summary = "겟 보이드를 테스트함",
            description = "겟 작성 방법",
            method = "GET"
    )
    @GetMapping(path = "/test1")
    public void test1get(){
        log.info("test1 get - {}");
    }
    
    @Operation(
            summary = "포스트 보이드룰 테스트함",
            description = "포스트 작성",
            method = "POST"
    )
    @PostMapping(path = "/test1")
    public void test1post(){
        log.info("test1 post - {}");
    }

    @Operation(
            summary = "포스트 리퀘스트 바디를 테스트함",
            description = "리퀘스트 작성법",
            method = "POST"
    )
    @PostMapping(path = "/test2")
    public void test2post(@RequestBody UserReq dto){
        log.info("test2 request Body -{}", new Gson().toJson(dto));
    }

}
