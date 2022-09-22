package com.ui.seoul.seoulopenapi.biz.v1.service;

import com.ui.seoul.seoulopenapi.biz.v1.model.res.CulturalEventInfoRes;
import com.ui.seoul.seoulopenapi.biz.v1.model.res.RealTimeFineDustRes;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.method.StrignToModel;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dongAll.Grid;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dongAll.URLDate;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dongAll.VilageFcstInfo;
import com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dongAll.VilageFcstInfoServiceCreate;
import com.ui.seoul.seoulopenapi.common.config.RestCall;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainService {

    private final Logger logger = LoggerFactory.getLogger(MainService.class);
    private final CreateURLService createURLService;

    public List<RealTimeFineDustRes> DustService() {
        return StrignToModel.Builder.newInstance()
                .setString(RestCall.get(createURLService.DustURL()).toString())
                .ofJsonObject("ListAirQualityByDistrictService")
                .ofJsonArray("row")
                .ofListModel(RealTimeFineDustRes.class)
                ;
    }

    public List<CulturalEventInfoRes> culturalEventService() {
        return StrignToModel.Builder.newInstance()
                .setString(RestCall.get(createURLService.CulturalEventURL()).toString())
                .ofJsonObject("culturalEventInfo")
                .ofJsonArray("row")
                .ofListModel(CulturalEventInfoRes.class)
                ;
    }

    public String culturalSpaceService() {
        return StrignToModel.Builder.newInstance()
                .setString(RestCall.get(createURLService.CulturalSpaceURL()).toString())
                .ofJsonObject("culturalSpaceInfo")
                .ofJsonArray("row")
                .ofListModel(List.class)
                .toString()
                ;
    }

    public void VilageFcstInfoService(){
        VilageFcstInfoServiceCreate ud = new VilageFcstInfoServiceCreate();
        URLDate udc = ud.getVilageFcstInfoServiceDate();

        Map<Grid, List<VilageFcstInfo>> vilageFcstMap = new HashMap<>();

        for(Grid g : ud.getVilageFcstInfoServiceGridList()){

//            List<VilageFcstInfo>

//            vilageFcstMap.put(g, )
        }



    }

}
