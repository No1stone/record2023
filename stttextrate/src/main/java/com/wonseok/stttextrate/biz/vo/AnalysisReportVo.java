package com.wonseok.stttextrate.biz.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnalysisReportVo {

    
    private String answer;
    private String answerChar;
    private String answerSentence;

    private String sttAnswer;
    private String sttAnswerChar;
    private String sttAnswerSentence;

    private String totalCharRate;
    private String totalSentenceRate;
    private String charRate;
    private String sentenceRate;
    private String textMeaningRate;

    @Builder
    public AnalysisReportVo(String answer, String answerChar, String answerSentence, String sttAnswer, String sttAnswerChar, String sttAnswerSentence, String totalCharRate, String totalSentenceRate, String charRate, String sentenceRate, String textMeaningRate) {
        this.answer = answer;
        this.answerChar = answerChar;
        this.answerSentence = answerSentence;
        this.sttAnswer = sttAnswer;
        this.sttAnswerChar = sttAnswerChar;
        this.sttAnswerSentence = sttAnswerSentence;
        this.totalCharRate = totalCharRate;
        this.totalSentenceRate = totalSentenceRate;
        this.charRate = charRate;
        this.sentenceRate = sentenceRate;
        this.textMeaningRate = textMeaningRate;
    }

}
