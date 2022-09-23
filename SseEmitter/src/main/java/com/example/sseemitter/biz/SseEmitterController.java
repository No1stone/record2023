package com.example.sseemitter.biz;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SseEmitterController {

    private final SseEmitterService sseEmitterService;

    @GetMapping(path = "/test37/{seq}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter test37(@PathVariable(name = "seq") Long seq) {
        log.info("data - {} , {}", seq);
        return sseEmitterService.SseEmitter(seq);
    }

    @GetMapping(path = "/test38/{seq}/{data}")
    public void test38(@PathVariable(name = "seq") Long seq, @PathVariable(name = "data")String data) {
        log.info("data - {} , {}", seq);
        sseEmitterService.sendToSseEmitter(seq, data);
    }

    @GetMapping(path = "/test1")
    public String test1Datareturn(@RequestParam(name = "a")String a){
        log.info("request data - {}", a);
        return "SseReturn";
    }

    @PostMapping(path = "/test2")
    public String test2Datareturn(@RequestBody TestBody testBody){
        log.info("request data - {}", new Gson().toJson(testBody));
        return "SseReturn2";
    }


}
