package com.ui.seoul.seoulopenapi.biz.v1.schedule.data;

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
public class DustBean {

    private final MainService mainService;
    private final Logger logger = LoggerFactory.getLogger(DustBean.class);
    private List<RealTimeFineDustRes> DustList = new ArrayList<>();

    @PostConstruct
    public List<RealTimeFineDustRes> DustScheduleSet() {
        //컴포넌트 세팅
        this.DustList = mainService.DustService();
        return DustList;
    }

    @Bean
    public List<RealTimeFineDustRes> DustListGet() {
        return DustList;
    }

    public void listPut(RealTimeFineDustRes req) {
        DustList.add(req);
    }

    public void listRemove(String key) {
        DustList.remove(key);
    }

    public void listRemove(RealTimeFineDustRes req) {
        DustList.remove(req);
    }

    public void listClearAndNew() {
        DustList.clear();
        DustList = new ArrayList<>();
    }

}
