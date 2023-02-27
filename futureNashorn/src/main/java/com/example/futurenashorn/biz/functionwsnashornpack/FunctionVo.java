package com.example.futurenashorn.biz.functionwsnashornpack;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FunctionVo {

    /**
     * varList: functionNode 의 fParam[0], fParam[1] 값을 받는곳
     * callData: 콜봇이 유지하고있는 데이터
     * initSctipt: 자바스크립트
     */

    private List<String> varList;
    private HashMap callData;
    private String initSctipt;
    private int timeOut;

    @Builder
    public FunctionVo(List<String> varList, HashMap callData, String initSctipt, int timeOut) {
        this.varList = varList;
        this.callData = callData;
        this.initSctipt = initSctipt;
        this.timeOut = timeOut;
    }


}
