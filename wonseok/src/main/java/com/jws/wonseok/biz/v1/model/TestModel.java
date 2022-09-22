package com.jws.wonseok.biz.v1.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestModel {

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    @Builder
    TestModel(String a, String b, String c, String d, String e, String f, String g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }


}
