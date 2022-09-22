package com.ui.seoul.seoulopenapi.biz.v1.schedule.data;

import com.ui.seoul.seoulopenapi.biz.v1.model.res.CulturalEventInfoRes;
import com.ui.seoul.seoulopenapi.biz.v1.model.res.RealTimeFineDustRes;
import com.ui.seoul.seoulopenapi.biz.v1.service.MainService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CulturalEventBean {
    private final MainService mainService;
    private final Logger logger = LoggerFactory.getLogger(DustBean.class);
    private List<CulturalEventInfoRes> dataList = new ArrayList<>();

    @PostConstruct
    public List<CulturalEventInfoRes> CulturalEventScheduleSet() {
        //컴포넌트 세팅
        this.dataList = mainService.culturalEventService();
        return dataList;
    }

    @Bean
    public List<CulturalEventInfoRes> CulturalEventListGet() {
        return dataList;
    }

    public void listPut(CulturalEventInfoRes req) {
        dataList.add(req);
    }

    public void listRemove(String key) {
        dataList.remove(key);
    }

    public void listRemove(CulturalEventInfoRes req) {
        dataList.remove(req);
    }

    public void listclearAndNew() {
        dataList.clear();
        dataList = new ArrayList<>();
    }
}
