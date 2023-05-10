package com.wonseok.stttextrate.biz.cont;

import com.google.gson.Gson;
import com.wonseok.stttextrate.biz.servi.SttTextRateService;
import com.wonseok.stttextrate.biz.vo.AnalysisReportVo;
import com.wonseok.stttextrate.biz.vo.ExcelDownloadVo;
import com.wonseok.stttextrate.biz.vo.ExcelUploadVo;
import com.wonseok.stttextrate.biz.vo.StringAnalysisVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/analysis")
@CrossOrigin("*")
public class SttTextRateControler {
    //https://springdoc.org/#javadoc-support
    //8. Migrating from SpringFox
    //12 F.A.Q
    //12.75. How can i define different schemas for the same class?
    private final SttTextRateService sttTextRateService;

    @PostMapping("/value")
    public AnalysisReportVo stringAnalysis(@RequestBody StringAnalysisVo dto) {
        log.info(" stringAnalysis - {} ", new Gson().toJson(dto));
        return sttTextRateService.stringAnalysis(dto);
    }

    @Operation(summary = "Get thing", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = {
                            @Content(mediaType = "application/vnd.ms-excel", schema = @Schema(type = "String", format = "binary")),
                            @Content(mediaType = "application/octet-stream", schema = @Schema(type = "String", format = "binary"))
                    }
            ),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true)))
    }
    )
    @GetMapping("/uploadform")
    public void uploadform() throws IOException {
        sttTextRateService.ExcelDownload("UploadForm", Arrays.asList(ExcelUploadVo.builder().answer("").sttAnswer("").build()), Arrays.asList("answer", "sttAnswer"));
    }


    @Operation(summary = "엑셀업로드 -> 엑셀파일로 다운로드(업로드와 동시에 다운로드는 유아이에서 지원안함)", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = {
                            @Content(mediaType = "application/vnd.ms-excel", schema = @Schema(type = "String", format = "binary")),
                            @Content(mediaType = "application/octet-stream", schema = @Schema(type = "String", format = "binary"))
                    }
            ),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true)))
    }
    )
    @PostMapping(value = "/upload"
            , produces = {"application/vnd.ms-excel", "application/octet-stream"}
            , consumes = {"multipart/form-data"}
    )
    public void upload(@RequestParam("files") MultipartFile dto) throws IOException {
        sttTextRateService.ExcelDownload("AnalysisReport", sttTextRateService
                .ExcelUploadConvert(dto, ExcelUploadVo.class)
                .stream()
                .map(e -> e.toAnalysis()
                        .toExcelDownload())
                .toList(), Arrays.asList("answer", "sttAnswer"));
//    return ResponseEntity.ok().build();
//        ResponseEntity.ok(new FileOutputStream()).build();
    }
    @Operation(summary = "엑셀업로드 -> Json 리턴")
    @PostMapping(value = "/uploadjson", consumes = {"multipart/form-data"})
    public List<ExcelDownloadVo> uploadJson(@RequestParam("files") MultipartFile dto) throws IOException {
        return sttTextRateService
                .ExcelUploadConvert(dto, ExcelUploadVo.class)
                .stream()
                .map(e -> e.toAnalysis()
                        .toExcelDownload())
                .toList();
    }

}


