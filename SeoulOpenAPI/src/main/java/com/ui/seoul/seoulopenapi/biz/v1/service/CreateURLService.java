package com.ui.seoul.seoulopenapi.biz.v1.service;

import com.google.gson.Gson;
import com.ui.seoul.seoulopenapi.biz.v1.model.req.RealTimeFineDustReq;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.*;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.method.URLBuilder;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dongAll.Grid;
import com.ui.seoul.seoulopenapi.common.config.RestCall;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateURLService {

    private final Logger logger = LoggerFactory.getLogger(CreateURLService.class);
    @Value("${seoul.open.usekey}")
    private String seoulApiUsingKey;

    @Value("${gonggong.data.usekey}")
    private String GongGongapiUsingKey;

    public String DustURL() {
        return URLBuilder.Builder.newInstance()
                .setSchema(URLType.HTTP.getURL())
                .setPreURL(URLType.서울시도메인.getURL())
                .setPort(URLType.prot8088.getURL())
                .setKey(seoulApiUsingKey)
                .setApiURL(URLType.미세먼지URL.getURL())
                .seoulBuild()
                ;
    }

    public String CulturalEventURL() {
        return URLBuilder.Builder.newInstance()
                .setSchema(URLType.HTTP.getURL())
                .setPreURL(URLType.서울시도메인.getURL())
                .setPort(URLType.prot8088.getURL())
                .setKey(seoulApiUsingKey)
                .setApiURL(URLType.문화정보URL.getURL())
                .seoulBuild()
                ;
    }

    public String CulturalSpaceURL() {
        return URLBuilder.Builder.newInstance()
                .setSchema(URLType.HTTP.getURL())
                .setPreURL(URLType.서울시도메인.getURL())
                .setPort(URLType.prot8088.getURL())
                .setKey(seoulApiUsingKey)
                .setApiURL(URLType.문화공간URL.getURL())
                .seoulBuild()
                ;
    }

    public String ForeCastAreaURL() {
        return URLType.HTTP.getURL() + "://"
                + URLType.예보구역정보URL
                + "?serviceKey=" + GongGongapiUsingKey
                + "&pageNo=1"
                + "&numOfRows=300"
                + "&dataType=json"
                + "&regId=11B10101"
                ;
    }

    public String VilageFcstInfoService(String nx, String ny, String date, String time) {
        Grid grid = new Grid();
        grid.setGridx(nx);
        grid.setGridy(ny);
        return VilageFcstInfoService(grid, date, time);
    }

    public String VilageFcstInfoService(Grid grid, String date, String time) {
        return "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"
                + "?ServiceKey=" + GongGongapiUsingKey
                + "&pageNo=1"
                + "&numOfRows=1000"
                + "&dataType=JSON"
                + "&base_date=" + date
                + "&base_time=" + time
                + "&nx=" + grid.getGridx()
                + "&ny=" + grid.getGridy();
    }


}
