package com.wonseok.stttextrate.biz.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.stream.Streams;
import org.apache.commons.text.similarity.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @Schema(title = "자카드유사도일치율", name = "similarityRate", description = "자카드일치율", example = "100%")
    private String jaccardSimilarityRate;
    @JsonProperty
    @Schema(title = "cosineDistance", name = "cosineDistance", description = "cosineDistance", example = "100%")
    private String cosineDistance;
    @JsonProperty
    @Schema(title = "코사인유사도일치율", name = "cosineSimilarityRate", description = "코사인유사도", example = "100%")
    private String cosineSimilarityRate;
    @JsonProperty
    @Schema(title = "levenshteinDistance", name = "levenshteinDistance", description = "levenshteinDistance", example = "100%")
    private String levenshteinDistance;
    @JsonProperty
    @Schema(title = "editDistance", name = "editDistance", description = "editDistance", example = "100%")
    private String editDistance;


    @JsonProperty
    @Schema(title = "문장단위일치율", name = "sentenceRate", description = "문장단위일치율", example = "100%")
    private String sentenceRate;
    @JsonProperty
    @Schema(title = "어근일치율", name = "textMeaningRate", description = "어근일치율", example = "100%")
    private String textMeaningRate;

    @Builder
    public AnalysisReportVo(StringAnalysisVo val) {
        this.answer = val.getAnswer().length() > 30 ? val.getAnswer().substring(0, 30) + "..." : val.getAnswer();
        this.answerChar = val.getAnswerChar();
        this.answerSentence = val.getAnswerSentence();
        this.sttAnswer = val.getSttAnswer().length() > 30 ? val.getSttAnswer().substring(0, 30) + "..." : val.getSttAnswer();
        this.sttAnswerChar = val.getSttAnswerChar();
        this.sttAnswerSentence = val.getSttAnswerSentence();
        this.totalCharRate = totalCharRate(val);
        this.totalSentenceRate = totalSentenceRate(val);
        this.charRate = charRate(val);
        this.cosineDistance = cosineDistance(val);
        this.jaccardSimilarityRate = jaccardSimilarityRate(val);
        this.cosineSimilarityRate = cosineSimilarity(val);
        this.levenshteinDistance = levenshteinDistance(val);
        this.editDistance = editDistance(val);
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
        String answer = dto.getAnswer().replaceAll(" ", "");
        String sttAnswer = dto.getSttAnswer().replaceAll(" ", "");
        char[] maxChar;
        char[] minChar;
        int suc = 0;
        int fail = 0;
        int gap = (int) (answer.length() - sttAnswer.length());
        int originCount = answer.length();
        if (gap > 0) {
            maxChar = new char[answer.toCharArray().length];
            maxChar = answer.toCharArray();
            minChar = new char[sttAnswer.toCharArray().length];
            minChar = sttAnswer.toCharArray();
        } else {
            maxChar = new char[sttAnswer.toCharArray().length];
            maxChar = sttAnswer.toCharArray();
            minChar = new char[answer.toCharArray().length];
            minChar = answer.toCharArray();
            gap = gap * -1;
        }
        int flag = 0;
        try {
            for (int i = 0; i < minChar.length - 1; i++) {
                if (minChar[i] == maxChar[i + flag]) {
                    suc += 1;
                } else {
                    int failflag = 1;
                    for (int j = 0; j < gap; j++) {
                        int fullChar = 0;
                        if (maxChar.length > i + flag + j + 1) {
                            fullChar = maxChar.length;
                        } else {
                            fullChar = maxChar[fullChar];
                        }
                        if (minChar[i] == fullChar) {
                            System.out.println(minChar[i] + "   " + maxChar[fullChar]);
                            suc += 1;
                            flag += 1;
                            failflag = 0;
                            break;
                        }
                    }
                    fail += failflag;
                }
            }
        } catch (Exception e) {
            return "fail";
        }
        return String.format("%.2f", Math.floor(originCount) / Math.floor(originCount + fail + gap) * 100.0) + "%";
    }

    private String jaccardSimilarityRate(StringAnalysisVo dto) {
        List<String> origin = new ArrayList<>(Arrays.stream(dto.getAnswer().split(" ")).distinct().toList());
        List<String> stt = new ArrayList<>(Arrays.stream(dto.getSttAnswer().split(" ")).distinct().toList());
        List<String> max = new ArrayList<>();
        List<String> min = new ArrayList<>();
        List<String> minDelList = new ArrayList<>();
        int uCount = 0;
        int nCount = 0;
        try {
            if (origin.size() > stt.size()) {
                max = origin;
                min = stt;
            } else {
                max = stt;
                min = origin;
            }
            minDelList = new ArrayList<>(min);
            for (String e : max) {
                if (min.contains(e)) {
                    nCount += 1;
                    minDelList.remove(e);
                } else {
                    uCount += 1;
                }
            }
        } catch (Exception e) {
            return "fail";
        }
        return String.format("%.2f", (Math.floor(nCount) / Math.floor(nCount + minDelList.size() + uCount)) * 100) + "%";
    }

    private String cosineDistance(StringAnalysisVo dto) {
        int an = dto.getAnswer().split(" ").length;
        String stan = dto.getSttAnswer().replaceAll(" ", "");
        int maxLenth = Math.max(dto.getAnswer().split(" ").length, dto.getSttAnswer().split(" ").length);
        double temp = new CosineDistance().apply(dto.getAnswer(), dto.getSttAnswer());
        return String.format("%.2f", ((maxLenth - temp) / maxLenth) * 100) + "%";
    }

    private String cosineSimilarity(StringAnalysisVo dto) {
        List<String> an = Arrays.asList(dto.getAnswer().split(" ")).stream().sorted().toList();
        List<String> stan = Arrays.asList(dto.getSttAnswer().split(" ")).stream().sorted().toList();
        //리스트 합치고를 정렬한다.
        //둘이 완전다른 값이 있을수 있으니 둘을 합치고 중복제거한 리스트를 만든다.
        List<String> all = Stream.concat(an.stream(), stan.stream()).distinct().sorted().toList();
        int allSize = all.size();
        int A[] = new int[allSize];
        int B[] = new int[allSize];
//        System.out.println(new Gson().toJson(all));
        //해당 리스트로 카운팅을 한다.
        //A B를 세팅한다.
        for (int i = 0; i < allSize; i++) {
            A[i] = Collections.frequency(an, all.get(i));
            B[i] = Collections.frequency(stan, all.get(i));
        }
//        System.out.println(new Gson().toJson(A));
//        System.out.println(new Gson().toJson(B));
        if (A == null || B == null || A.length == 0 || B.length == 0 || A.length != B.length) {
            return "fail";
        }
        double sumProduct = 0;
        double sumASq = 0;
        double sumBSq = 0;
        for (int i = 0; i < A.length; i++) {
            sumProduct += A[i] * B[i];
            sumASq += A[i] * A[i];
            sumBSq += B[i] * B[i];
        }
        if (sumASq == 0 && sumBSq == 0) {
            return "fail";
        }
        return String.format("%.2f", sumProduct / (Math.sqrt(sumASq) * Math.sqrt(sumBSq)) * 100) + "%";
    }

    private String levenshteinDistance(StringAnalysisVo dto) {
        String an = dto.getAnswer().replaceAll(" ", "");
        String stan = dto.getSttAnswer().replaceAll(" ", "");
        int maxLenth = Math.max(an.length(), stan.length());
        double temp = new LevenshteinDistance().apply(an, stan);
        return String.format("%.2f", ((maxLenth - temp) / maxLenth) * 100) + "%";
    }

    private String editDistance(StringAnalysisVo dto) {
        String an = dto.getAnswer().replaceAll(" ", "");
        String stan = dto.getSttAnswer().replaceAll(" ", "");
        EditDistance<Integer> editDistance = new LevenshteinDistance();
        EditDistanceFrom<Integer> editDistanceFrom =
                new EditDistanceFrom<Integer>(editDistance, an);
        String mostSimilar = null;
        Integer shortestDistance = null;
        Integer distance = editDistanceFrom.apply(stan);
        if (shortestDistance == null || distance < shortestDistance) {
            shortestDistance = distance;
            mostSimilar = stan;
        }
        return shortestDistance + "EA";
    }

}
