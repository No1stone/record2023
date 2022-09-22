package com.naver.band.biz.v1.model.type;

public enum BandURLType {

    http("http://"),
    BaseURL("auth.band.us"),
    apiPath("/oauth2/authorize"),
    AuthToken("/oauth2/token")


    ;

    private String s;
    BandURLType(String s){
        this.s = s;
    }
    public String getS(){
        return this.s;
    }
    public String getName(){
        return name();
    }

}
