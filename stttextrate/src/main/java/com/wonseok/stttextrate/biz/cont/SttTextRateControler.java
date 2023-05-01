package com.wonseok.stttextrate.biz.cont;

import com.google.gson.Gson;
import com.wonseok.stttextrate.biz.servi.SttTextRateService;
import com.wonseok.stttextrate.biz.vo.StringAnalysisVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SttTextRateControler {

    //https://springdoc.org/#javadoc-support
    //8. Migrating from SpringFox
    //12 F.A.Q

    private final SttTextRateService sttTextRateService;

    @PostMapping("/stringAnalysis")
    public void stringAnalysis(@RequestBody StringAnalysisVo dto){

    log.info(" stringAnalysis - {} ", new Gson().toJson(dto));

    }

}
