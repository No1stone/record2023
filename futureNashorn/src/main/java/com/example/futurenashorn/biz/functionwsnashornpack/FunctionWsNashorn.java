package com.example.futurenashorn.biz.functionwsnashornpack;

import com.example.futurenashorn.biz.functionwsnashornpack.ex.WsNotAvailableException;
import com.google.gson.Gson;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FunctionWsNashorn {
    /**
     * varList: functionNode 의 fParam[0], fParam[1] 값을 받는곳
     * callData: 콜봇이 유지하고있는 데이터
     * initSctipt: 자바스크립트
     */

    private List<String> varList;
    private HashMap callData = new HashMap<>();
    private String initSctipt;
    private List<String> reservesWord = Arrays.asList("while", "sleep", "timeout", "interval","$(");

    public static FunctionWsNashorn builder(int timeMilli) throws ExecutionException, InterruptedException, TimeoutException {
        int time = 5000;
        if (timeMilli > 0 && timeMilli < time) time = timeMilli;
        return Executors.newSingleThreadExecutor().submit(FunctionWsNashorn::new).get(time, TimeUnit.MILLISECONDS);
    }

    public FunctionWsNashorn create(FunctionVo dto) {
        if (dto.getInitSctipt().length() < 5) throw new WsNotAvailableException("코드길이가 너무 적습니다.");
        if (dto.getVarList().size() < 1) throw new WsNotAvailableException("파라미터가 없습니다.");
        this.varList = dto.getVarList();
        this.initSctipt = dto.getInitSctipt();
        return this;
    }

    public Map build() throws ScriptException {
        ScriptEngine se = new NashornScriptEngineFactory().getScriptEngine();
        for (String e : varList) {
            if (callData.containsKey(e)) {
                se.put(e, callData.get(e));
            } else {
                se.put(e, "");
            }
        }
        se.eval(this.initSctipt);
        for (String e : varList) {
            callData.put(e, se.get(e));
        }
        return this.callData;
    }

    public FunctionWsNashorn noTag() {
        if (this.initSctipt.matches("<.+?>")) throw new WsNotAvailableException("HTML TAG는 입력 할 수 없습니다.");
        return this;
    }

    public FunctionWsNashorn CheckBlackList() {
        String copy = this.initSctipt;
        for (String e : reservesWord) {
            if (copy.toLowerCase().contains(e)) throw new WsNotAvailableException("JAVASCRIPT만 사용해주세요.");
        }
        return this;
    }

}
