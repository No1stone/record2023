package com.example.swagger.biz;

import com.example.swagger.biz.model.UserReq;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근") })
    @PostMapping(path = "/test2")
    public void test2post(@RequestBody UserReq dto){
        log.info("test2 request Body -{}", new Gson().toJson(dto));
    }

}
