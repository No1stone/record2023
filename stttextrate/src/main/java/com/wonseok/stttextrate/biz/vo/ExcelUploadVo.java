package com.wonseok.stttextrate.biz.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ExcelUploadVo {

    private String answer;
    private String sttAnswer;

    @Builder
    public ExcelUploadVo(String answer, String sttAnswer) {
        this.answer = answer;
        this.sttAnswer = sttAnswer;
    }

    public AnalysisReportVo toAnalysis(){
        StringAnalysisVo sav = new StringAnalysisVo();
        sav.setAnswer(this.answer);
        sav.setSttAnswer(this.sttAnswer);
        return AnalysisReportVo.builder().val(sav).build();
    }
}
