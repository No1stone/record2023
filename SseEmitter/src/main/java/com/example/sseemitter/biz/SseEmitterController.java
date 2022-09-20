package com.example.sseemitter.biz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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

}
