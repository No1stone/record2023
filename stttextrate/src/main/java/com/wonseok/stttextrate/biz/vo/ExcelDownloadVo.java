package com.wonseok.stttextrate.biz.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExcelDownloadVo {

    private String answer;
    private Long answerChar;
    private Long answerSentence;
    private String sttAnswer;
    private Long sttAnswerChar;
    private Long sttAnswerSentence;
    private String totalCharRate;
    private String totalSentenceRate;
    private String charRate;
    private String jaccardSimilarityRate;
    private String cosineDistance;
    private String cosineSimilarityRate;
    private String levenshteinDistance;
    private String editDistance;
    private String hammingDistance;

    @Builder
    public ExcelDownloadVo(String answer, Long answerChar, Long answerSentence, String sttAnswer, Long sttAnswerChar, Long sttAnswerSentence, String totalCharRate, String totalSentenceRate, String charRate, String jaccardSimilarityRate, String cosineDistance, String cosineSimilarityRate, String levenshteinDistance, String editDistance, String hammingDistance) {
        this.answer = answer;
        this.answerChar = answerChar;
        this.answerSentence = answerSentence;
        this.sttAnswer = sttAnswer;
        this.sttAnswerChar = sttAnswerChar;
        this.sttAnswerSentence = sttAnswerSentence;
        this.totalCharRate = totalCharRate;
        this.totalSentenceRate = totalSentenceRate;
        this.charRate = charRate;
        this.jaccardSimilarityRate = jaccardSimilarityRate;
        this.cosineDistance = cosineDistance;
        this.cosineSimilarityRate = cosineSimilarityRate;
        this.levenshteinDistance = levenshteinDistance;
        this.editDistance = editDistance;
        this.hammingDistance = hammingDistance;
    }

}
