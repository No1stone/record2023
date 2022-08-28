package com.example.redisinittest.biz;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

public class AssertService extends Assert{

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
        notNull(o, "Null일수없슴.");
    return this;
    }

    public AssertService test1(Object o){
        isTrue(o == null ? true : false);
        return this;
    }

}
