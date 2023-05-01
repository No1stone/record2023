package com.wonseok.stttextrate.biz.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@NoArgsConstructor
public class StringAnalysisVo {


    @JsonProperty
    @Schema(name = "answer", description = "정답지", example = "정답지")
    private String answer;

    @JsonProperty
    @Schema(name = "sttAnswer", description = "STT분석값", example = "STT분석값")
    private String sttAnswer;

    @Schema(hidden = true)
    private Long answerChar;

    @Schema(hidden = true)
    private Long answerSentence;

    @Schema(hidden = true)
    private Long sttAnswerChar;

    @Schema(hidden = true)
    private Long sttAnswerSentence;

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setSttAnswer(String sttAnswer) {
        this.sttAnswer = sttAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getSttAnswer() {
        return sttAnswer;
    }

    public Long getAnswerChar() {
        return (long)this.answer.length();
    }

    public Long getAnswerSentence() {
        return Arrays.stream(this.answer.split(" ")).count();
    }

    public Long getSttAnswerChar() {
        return (long) this.sttAnswer.length();
    }

    public Long getSttAnswerSentence() {
        return Arrays.stream(this.sttAnswer.split(" ")).count();
    }
}
