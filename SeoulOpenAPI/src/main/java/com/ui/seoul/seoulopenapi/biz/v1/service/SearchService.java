package com.ui.seoul.seoulopenapi.biz.v1.service;

import com.ui.seoul.seoulopenapi.biz.v1.model.res.CulturalEventInfoRes;
import com.ui.seoul.seoulopenapi.biz.v1.model.res.RealTimeFineDustRes;
import com.ui.seoul.seoulopenapi.biz.v1.schedule.data.CulturalEventBean;
import com.ui.seoul.seoulopenapi.biz.v1.schedule.data.DustBean;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final DustBean dustBean;
    private final CulturalEventBean culturalEventBean;
    private final Logger logger = LoggerFactory.getLogger(SearchService.class);
    private final ModelMapper modelMapper;

    public RealTimeFineDustRes DustSearchService(String gu) {
        return dustBean.DustListGet().stream().filter(e -> e.getMSRSTENAME().equals(gu)).findFirst().orElse(null);
    }


    public List<CulturalEventInfoRes> culturalEventSearchService() {
        return culturalEventBean.CulturalEventListGet();
    }

    public void ForeCastAreaService() {

    }
}
