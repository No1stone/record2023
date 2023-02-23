package com.example.futurenashorn.biz.nas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class FunctionVo {

    private Map initParam;
    private String initCode;
    private int timeOut;


}
