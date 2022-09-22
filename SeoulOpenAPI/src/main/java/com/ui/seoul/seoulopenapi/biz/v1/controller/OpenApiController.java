package com.ui.seoul.seoulopenapi.biz.v1.controller;

import com.google.gson.Gson;
import com.ui.seoul.seoulopenapi.biz.v1.model.res.CulturalEventInfoRes;
import com.ui.seoul.seoulopenapi.biz.v1.model.res.RealTimeFineDustRes;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.method.JsonToModel;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.ShortTermForecastType;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong.GangnamGu;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dongAll.DongAllList;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dongAll.Grid;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dongAll.VilageFcstInfo;
import com.ui.seoul.seoulopenapi.biz.v1.service.CreateURLService;
import com.ui.seoul.seoulopenapi.biz.v1.service.MainService;
import com.ui.seoul.seoulopenapi.biz.v1.service.SearchService;
import com.ui.seoul.seoulopenapi.biz.v1.service.TestService;
import com.ui.seoul.seoulopenapi.common.config.RestCall;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/API/V1")
@RequiredArgsConstructor
public class OpenApiController {

    private final Logger logger = LoggerFactory.getLogger(OpenApiController.class);
    private final MainService mainService;
    private final TestService testService;
    private final SearchService searchService;
    private final CreateURLService createURLService;

//    @GetMapping(path = "/test1")
//    public String BuildTest1Controller(){
//       return mainService.DustService();
//    }

    @GetMapping(path = "/test2")
    public String BuildTes2tController() {
        return mainService.culturalSpaceService();
    }

    @GetMapping(path = "/test3")
    public String BuildTes3tController() {
        return mainService.culturalSpaceService();
    }

    @GetMapping(path = "/test4")
    public String BuildTes4tController() {
        testService.dateAfter("2022-05-12 00:00:00.0");
        return "aa";
    }

    @GetMapping(path = "/dust/{gu}")
    public RealTimeFineDustRes fineDustController(@PathVariable(name = "gu") String gu) {
        return searchService.DustSearchService(gu);
    }

    @GetMapping(path = "/culturalEvent")
    public List<CulturalEventInfoRes> culturalEventController() {
        return searchService.culturalEventSearchService();
    }

    //ForeCastArea
    //기상예보구역 정보 조회서비스
    @GetMapping(path = "/ForeCastArea/{gu}")
    public void ForeCastAreaController(@PathVariable(name = "gu") String gu) {
        searchService.ForeCastAreaService();
    }


//    서울시 챗봇 단변 데이터 활용
//    https://www.data.go.kr/iim/api/selectAPIAcountView.do   주소
//    https://www.data.go.kr/data/15000415/openapi.do  기상청_기상특보 조회서비스
//    https://www.data.go.kr/data/15057111/openapi.do  기상청_예보구역정보 조회서비스
//    https://www.data.go.kr/data/15059468/openapi.do  기상청_중기예보 조회서비스
//    https://www.data.go.kr/data/15085288/openapi.do  기상청_생활기상지수 조회서비스(3.0)
//    https://www.data.go.kr/data/15084084/openapi.do  기상청_단기예보 ((구)_동네예보) 조회서비스

    @GetMapping(path = "/eTest/{gu}")
    public void EnumTestGu(@PathVariable(name = "gu") String gu) {
        Grid startWhit = Arrays.asList(DongAllList.values()).stream()
                .filter(e -> e.getName().startsWith(gu)).findFirst().orElse(null).getGid();
        logger.info("startWhit - {}", startWhit);
    }
    //http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst?ServiceKey=0K4Oa1B8HMxWjZqMb8Iea9scmWEyZBAlV8IcsQVsBriDgcYtNj60ahAqVbDf0PGkhuXVDPJEOgp5ixvTl2ZSBg%3D%3D&pageNo=1&numOfRows=1000&dataType=JSON&base_date=20220411&base_time=1630&nx=60&ny=128

    private final RestTemplate restTemplate;

    @GetMapping(path = "/dateTest")
    public void DateTest() throws IOException {
        String aurl = createURLService.VilageFcstInfoService("60", "129", "20220413", "0200");
        Object restCall = RestCall.get(aurl);
        List<VilageFcstInfo> listVilage1 = JsonToModel
                .builder(restCall)
                .ofObject("response")
                .ofObject("body")
                .ofObject("items")
                .ofArrayModel("item", VilageFcstInfo.class);
        logger.info("result = ={}", new Gson().toJson(listVilage1));
    }

}

