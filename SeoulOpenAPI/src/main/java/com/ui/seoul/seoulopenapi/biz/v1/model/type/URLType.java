package com.ui.seoul.seoulopenapi.biz.v1.model.type;

public enum URLType {

    HTTP("http"),
    HTTPS("https"),
    prot8088("8088"),
    서울시도메인("openAPI.seoul.go.kr"),
    미세먼지URL("/json/ListAirQualityByDistrictService/1/30/"),
    문화정보URL("/json/culturalEventInfo/1/1000/"),
    문화공간URL("/json/culturalSpaceInfo/1/30/"),

    공공데이터도메인("apis.data.go.kr"),
    예보구역정보URL("/1360000/FcstZoneInfoService/getFcstZoneCd")
    ;

    private String URLValue;
    URLType(String URLValue){
    this.URLValue = URLValue;
    }
    public String getURL(){
        return this.URLValue;
    }


}
