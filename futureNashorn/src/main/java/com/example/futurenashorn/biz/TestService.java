package com.example.futurenashorn.biz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {
    public void test1() throws InterruptedException, ExecutionException, TimeoutException {

        Future f = null;

        ExecutorService service = Executors.newSingleThreadExecutor();

        f = service.submit(this::TimeoutSllep);
        log.info("get value - {}",f.get(5, TimeUnit.SECONDS));

    }

    private String TimeoutSllep() throws InterruptedException {
        log.info("timeout init");
        Thread.sleep(4000);
        log.info("timeout out");
        return "sleep5second";
    }
}
