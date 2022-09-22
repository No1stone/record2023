package com.naver.band.biz.v1.method;

public class BandURL {
    private String schema = "";
    private String baseURL = "";
    private String api = "";
    private String param = "";

    public static BandURL builder() {
        return new BandURL();
    }

    public BandURL schema(String schema) {
        this.schema = schema;
        return this;
    }

    public BandURL baseURL(String baseURL) {
        this.baseURL = baseURL;
        return this;
    }

    public BandURL api(String api) {
        this.api = api;
        return this;
    }

    public BandURL param(String param, String arg) {
        String con = "" ;
        if (this.param.length() > 0) {
            con = "&" ;
        } else {
            con = "?" ;
        }
        this.param += con + param + "=" + arg;
        return this;
    }

    public String build() {
        return this.schema+this.baseURL+this.api+this.param;
    }


}
