package com.example.futurenashorn.biz.nas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class FunctionWsNashorn {

    private Map param;
    private Map result = new HashMap<>();
    private String code;
    private boolean forLoop = false;
    private boolean maxSize = false;
    private boolean whileLoop = false;
    private boolean htmlTag = false;
    private boolean sleep = false;
    private boolean timeout = false;
    private boolean interval = false;
    private boolean jquery = false;
    private boolean keyChk = false;
    private List<String> reservesWord = Arrays.asList("for", "while", "sleep", "timeout", "interval");

    private FunctionWsNashorn() {
    }

    public static FunctionWsNashorn builder(int timeMilli) throws ExecutionException, InterruptedException, TimeoutException {
        int time = 5000;
        if (timeMilli > 0 && timeMilli < time) time = timeMilli;
        return Executors.newSingleThreadExecutor().submit(FunctionWsNashorn::new).get(time, TimeUnit.MILLISECONDS);
    }

    public FunctionWsNashorn create(FunctionVo dto) {
        if (dto.getInitCode().length() > 5) throw new IllegalArgumentException();
        if (dto.getInitParam().size() > 1) throw new IllegalArgumentException();
        this.param = dto.getInitParam();
        this.code = dto.getInitCode();
        return this;
    }

    public Map build() {
        return result;
    }

    public FunctionWsNashorn noTag() {
        if ("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>".matches(this.code)) this.htmlTag = true;
        return this;
    }

}
