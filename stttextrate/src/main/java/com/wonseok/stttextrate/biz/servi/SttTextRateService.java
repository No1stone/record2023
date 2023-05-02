package com.wonseok.stttextrate.biz.servi;

import com.wonseok.stttextrate.biz.vo.AnalysisReportVo;
import com.wonseok.stttextrate.biz.vo.StringAnalysisVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SttTextRateService {


    public AnalysisReportVo stringAnalysis(StringAnalysisVo dto) {
        return AnalysisReportVo.builder()
                .val(dto)
                .build();
    }

}
