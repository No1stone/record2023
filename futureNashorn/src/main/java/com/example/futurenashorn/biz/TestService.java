package com.example.futurenashorn.biz;

import com.example.futurenashorn.biz.functionwsnashornpack.FunctionVo;
import com.example.futurenashorn.biz.functionwsnashornpack.FunctionWsNashorn;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
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

    public String Nasgorn() throws ExecutionException, InterruptedException, TimeoutException, ScriptException {
        ScriptEngine se = new NashornScriptEngineFactory().getScriptEngine();

        se.put("예약시간1", 1);
        se.put("예약시간2", 2);
        se.put("par3", 3);
        se.put("par4", "par4 = par3 + par3");

        se.eval("예약시간1 = 10");
        se.eval("예약시간2 = 11");
        se.eval("par3 = 2");
        se.eval("par4");

        log.info("par1 - {}", se.get("예약시간1"));
        log.info("par2 - {}", se.get("예약시간2"));
        log.info("par3 - {}", se.get("par3"));
        log.info("par4 - {}", se.get("par4"));


//        se.eval();
//        FunctionWsNashorn.builder(6000).create().build();
        return "";
    }

    public void test2() throws ExecutionException, InterruptedException, TimeoutException, ScriptException {

        Map data =  new HashMap<>();
        data.put("param1","value1");
//        String initCode = "a=1";
//        String initCode = "<p><div>asdasd</div>";
        String initCode = "a=1 b=2 c=3";
        Map result = FunctionWsNashorn
                .builder(5000)
                .create(FunctionVo.builder().callData((HashMap) data).initSctipt(initCode).build())
                .CheckBlackList()
                .noTag()
                .build();

    }
}
