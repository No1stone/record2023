package com.ui.seoul.seoulopenapi.biz.v1.model.type;

import java.util.function.UnaryOperator;

public enum TestURLType {

    REAL_TIME_FINE_DUST(usingKey -> String.format("http://openAPI.seoul.go.kr:8088/%s/xml/ListAirQualityByDistrictService/1/5/", usingKey));

    private UnaryOperator<String> usingKey;
    TestURLType(UnaryOperator<String> usingKey) {this.usingKey = usingKey;}
    public String urlGet(String usingKey) {return this.usingKey.apply(usingKey);
    }
}
