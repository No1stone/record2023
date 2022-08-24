package com.example.redisinittest.biz;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

public class AssertService {

    private String s;


    public static AssertService builder(){
        return new AssertService();
    }

    public AssertService stringCheck(String s){
        if(!s.matches("^[a-zㄱ-힣]]")){
            new IllegalArgumentException();
        }
        return this;
    }

    public AssertService notnull(Object o) {
        Assert.notNull(o, "Null일수없슴.");
    return this;
    }


}
