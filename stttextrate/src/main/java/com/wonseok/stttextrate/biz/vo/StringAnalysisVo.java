package com.wonseok.stttextrate.biz.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StringAnalysisVo {

    private String answer;
    private String sttAnswer;

    @Builder
    public StringAnalysisVo(String answer, String sttAnswer) {
        this.answer = answer;
        this.sttAnswer = sttAnswer;
    }

}
