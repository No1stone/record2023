package com.example.redisinittestpub.biz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PubController {

    private final PubService pubService;

    @GetMapping(path = "/test1/{val}")
    public void PubCont(@PathVariable(name = "val")String val){
        log.info("pub val", val);
        pubService.sendRedisTemplate(val);
    }


}
