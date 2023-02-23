package com.example.futurenashorn.biz.functionwsnashornpack;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
public class FunctionVo {

    private HashMap initParam = new HashMap<>();
    private String initCode;
    private int timeOut;

    @Builder
    public FunctionVo(HashMap initParam, String initCode, int timeOut) {
        this.initParam = initParam;
        this.initCode = initCode;
        this.timeOut = timeOut;
    }
}
