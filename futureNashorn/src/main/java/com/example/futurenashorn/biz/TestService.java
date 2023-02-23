package com.example.futurenashorn.biz;

import com.example.futurenashorn.biz.functionwsnashornpack.FunctionVo;
import com.example.futurenashorn.biz.functionwsnashornpack.FunctionWsNashorn;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import java.util.HashMap;
import java.util.Map;
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

    private String Nasgorn() throws ExecutionException, InterruptedException, TimeoutException {
        ScriptEngine se = new NashornScriptEngineFactory().getScriptEngine();

//        se.eval();
//        FunctionWsNashorn.builder(6000).create().build();
        return "";
    }

    public void test2() throws ExecutionException, InterruptedException, TimeoutException {

        Map data =  new HashMap<>();
        data.put("param1","value1");
//        String initCode = "a=1";
//        String initCode = "<p><div>asdasd</div>";
        String initCode = "a=1 b=2 c=3";
        FunctionWsNashorn.builder(5000).create(FunctionVo.builder().initParam((HashMap) data).initCode(initCode).build()).noTag().build();
    }
}
