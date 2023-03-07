package com.example.excelcommon;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final ExcelService excelService;

    @PostMapping("/test25")
    public void test25(@RequestParam("files") MultipartFile dto) throws IOException {
        log.info("test25 - {}", new Gson().toJson(dto.getOriginalFilename()));
        log.info("test25 - {}", new Gson().toJson(dto));
//        testRestService.test27(dto);
        var result = excelService.ExcelUploadConvert(dto, TextClass.class);

        log.info("result - {}", new Gson().toJson(result));

    }


}
