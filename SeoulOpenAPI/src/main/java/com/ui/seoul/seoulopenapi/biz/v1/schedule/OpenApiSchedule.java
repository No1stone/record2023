package com.ui.seoul.seoulopenapi.biz.v1.schedule;

import com.ui.seoul.seoulopenapi.biz.v1.schedule.data.DustBean;
import com.ui.seoul.seoulopenapi.biz.v1.service.MainService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class OpenApiSchedule {

    private final MainService mainService;
    private final DustBean dustBean;
    private final Logger logger = LoggerFactory.getLogger(OpenApiSchedule.class);
    @Scheduled(cron = "0 25 * * * ?")
    private void Deust(){
        logger.info("time - {}",LocalDateTime.now());
        //20 ~ 25분쯤 바뀜
        dustBean.listClearAndNew();
        dustBean.DustScheduleSet();
    }



}
