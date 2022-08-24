package com.example.sseemitter.biz;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class SseEmitterService {

    private Map<Long, SseEmitter> emiterMap = new HashMap<>();

    public SseEmitter SseEmitter(Long seq) {
        SseEmitter sseEmitter = new SseEmitter(1000L*60L*60L);
        log.info("sse info - {}", new Gson().toJson(sseEmitter));
        emiterMap.put(seq, sseEmitter);
        return sseEmitter;
    }

    public void sendToSseEmitter(Long seq, String data) {
        data = "aaaasssss";
        SseEmitter emitter = emiterMap.get(seq);
        try {
            emitter.send(
                    SseEmitter
                            .event()
                            .id(seq.toString())
                            .name("sse")
                            .data(data)
            )
            ;
        } catch (IOException exception) {
            throw new RuntimeException("연결 오류!");
        }
    }

}
