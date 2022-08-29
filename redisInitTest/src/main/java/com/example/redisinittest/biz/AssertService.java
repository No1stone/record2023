package com.example.redisinittest.biz;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

public class AssertService extends Assert{

    /**
     * 발리데이션과, 메세지 프로퍼티, 컨트롤러어드바이스와 어써트를 함께 사용하는
     * 프로젝트를 하나 만들어보자.
     */

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
