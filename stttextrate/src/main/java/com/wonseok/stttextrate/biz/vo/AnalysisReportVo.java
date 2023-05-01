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
public class AnalysisReportVo {

    @JsonProperty
    @Schema(title = "정답지", name = "answer", description = "분석한정답지", example = "정답지")
    private String answer;
    @JsonProperty
    @Schema(title = "정답지글자수", name = "answerChar", description = "정답지글자수", example = "80")
    private Long answerChar;
    @JsonProperty
    @Schema(title = "정답지문장수", name = "answerSentence", description = "정답지문장수", example = "10")
    private Long answerSentence;
    @JsonProperty
    @Schema(title = "STT분석값", name = "sttAnswer", description = "STT분석값", example = "STT분석값")
    private String sttAnswer;
    @JsonProperty
    @Schema(title = "STT글자수", name = "sttAnswerChar", description = "STT글자수", example = "80")
    private Long sttAnswerChar;
    @JsonProperty
    @Schema(title = "STT문장수", name = "sttAnswerSentence", description = "STT문장수", example = "10")
    private Long sttAnswerSentence;
    @JsonProperty
    @Schema(title = "글자수합계일치율", name = "totalCharRate", description = "글자수합계일치율", example = "100%")
    private String totalCharRate;
    @JsonProperty
    @Schema(title = "문장수일치율", name = "totalSentenceRate", description = "문장수일치율", example = "100%")
    private String totalSentenceRate;
    @JsonProperty
    @Schema(title = "글자단위일치율", name = "charRate", description = "글자단위일치율", example = "100%")
    private String charRate;
    @JsonProperty
    @Schema(title = "문장단위일치율", name = "sentenceRate", description = "문장단위일치율", example = "100%")
    private String sentenceRate;
    @JsonProperty
    @Schema(title = "어근일치율", name = "textMeaningRate", description = "어근일치율", example = "100%")
    private String textMeaningRate;

    @Builder
    public AnalysisReportVo(StringAnalysisVo val) {
        this.answer = val.getAnswer();
        this.answerChar = val.getAnswerChar();
        this.answerSentence = val.getAnswerSentence();
        this.sttAnswer = val.getSttAnswer();
        this.sttAnswerChar = val.getSttAnswerChar();
        this.sttAnswerSentence = val.getSttAnswerSentence();
        this.totalCharRate = totalCharRate(val);
        this.totalSentenceRate = totalSentenceRate(val);
        this.charRate = charRate(val);
        this.sentenceRate = sentenceRate;
        this.textMeaningRate = textMeaningRate;
    }

    private String totalCharRate(StringAnalysisVo dto) {
        Long max = Math.max(dto.getAnswerChar(), dto.getSttAnswerChar());
        Long min = Math.min(dto.getAnswerChar(), dto.getSttAnswerChar());
        return String.format("%.2f", Math.floor(min) / Math.floor(max) * 100.0) + "%";
    }

    private String totalSentenceRate(StringAnalysisVo dto) {
        Long max = Math.max(dto.getAnswerSentence(), dto.getSttAnswerSentence());
        Long min = Math.min(dto.getAnswerSentence(), dto.getSttAnswerSentence());
        return String.format("%.2f", Math.floor(min) / Math.floor(max) * 100.0) + "%";
    }

    private String charRate(StringAnalysisVo dto) {
        String answer = dto.getAnswer().replaceAll(" ","");
        String sttAnswer = dto.getSttAnswer().replaceAll(" ","");
        char[] maxChar;
        char[] minChar;
        int suc = 0;
        int fail = 0;
        int gap = (int) (answer.length() - sttAnswer.length());
        int flag= 0;
        System.out.println("gap - " + gap);
        System.out.println("answer - " + answer);
        System.out.println("sttAnswer - " + sttAnswer);
        if (gap > 0) {
            maxChar = answer.toCharArray();
            minChar = sttAnswer.toCharArray();
        } else {
            maxChar = sttAnswer.toCharArray();
            minChar = answer.toCharArray();
            gap = gap * -1;
        }
        for (int i = 0; i < minChar.length - 1; i++) {
            if (minChar[i] == maxChar[i]) {
                suc += 1;
                System.out.println("equals - " + minChar[i] + "  " + maxChar[i]);
            } else {
                System.out.println("else - " + minChar[i] + "  " + maxChar[i]);

                for (int j = 0; j < gap; j++) {
                    if (minChar[i] == maxChar[i + j + 1]) {
                        gap = gap - j + 1;
                        suc += 1;
                        continue;
                    }
                    fail += 1;
                }
            }
        }
        fail += gap;
        System.out.println("suc = " + suc);
        System.out.println("fail = " + fail);
        int max = suc + fail;
        int min = suc;
        return String.format("%.2f", Math.floor(min) / Math.floor(max) * 100.0) + "%";
    }

}
