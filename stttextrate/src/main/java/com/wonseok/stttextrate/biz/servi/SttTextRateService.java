package com.wonseok.stttextrate.biz.servi;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.wonseok.stttextrate.biz.vo.AnalysisReportVo;
import com.wonseok.stttextrate.biz.vo.StringAnalysisVo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SttTextRateService {

    private final HttpServletRequest httpServletRequest;
    private final HttpServletResponse httpServletResponse;

    public AnalysisReportVo stringAnalysis(StringAnalysisVo dto) {
        return AnalysisReportVo.builder()
                .val(dto)
                .build();
    }

    public void ExcelDownload(String fileName, List<?> data) throws IOException {
        List<String> title = new ArrayList<>();
        for (Field e : data.get(0).getClass().getDeclaredFields()) {
            title.add(e.getName());
        }
        ExcelDownload(fileName, data, title);
    }
    public void ExcelDownload(String fileName, List<?> data, List<String> title) throws IOException {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("data");
        CreationHelper createHelper = wb.getCreationHelper();
        Row row = sheet.createRow(0);
        CellStyle cellStyle1 = wb.createCellStyle();
        cellStyle1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        applyCellStyle(cellStyle1);
        CellStyle cellStyle2 = wb.createCellStyle();
        cellStyle2.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        cellStyle2.setWrapText(true);
        applyCellStyle(cellStyle2);
        AtomicInteger ai = new AtomicInteger();
        List<String> keySet = new ArrayList<>();
        for (String e : title) {
            Cell c = row.createCell(ai.getAndIncrement());
            c.setCellValue(e);
            c.setCellStyle(cellStyle1);
        }
        sheet.autoSizeColumn(0);
        for (Field e : data.get(0).getClass().getDeclaredFields()) {
            keySet.add(e.getName());
        }
        row.setHeight((short) 500);
        AtomicInteger ai1 = new AtomicInteger();
        for (Object e : data) {
            Row row1 = sheet.createRow(ai1.incrementAndGet());
            AtomicInteger ai2 = new AtomicInteger();
            JSONObject obj = new JSONObject(e);
            for (String f : keySet) {
                int rowNum = ai2.getAndIncrement();
                if (obj.names().toList().contains(f)) {
                    Cell c = row1.createCell(rowNum);
                    c.setCellValue(createHelper.createRichTextString(obj.get(f).toString()));
                    c.setCellStyle(cellStyle2);
                } else {
                    Cell c = row1.createCell(rowNum);
                    c.setCellValue(createHelper.createRichTextString(""));
                    c.setCellStyle(cellStyle2);
                }
                sheet.autoSizeColumn(rowNum);
                //sheet.setColumnWidth(rowNum, (sheet.getColumnWidth(rowNum))+1024 );
                sheet.setColumnWidth(rowNum, Math.min(255 * 100, sheet.getColumnWidth(rowNum) + 1200));
                row1.setHeight((short) 500);
            }
        }
        try (ServletOutputStream fileOut = httpServletResponse.getOutputStream())/*new FileOutputStream("base.xls"))*/ {
            wb.write(fileOut);
            httpServletResponse.setContentType("application/vnd.ms-excel; charset=EUC-KR");
            httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls; charset=EUC-KR");
            wb.write(httpServletResponse.getOutputStream());
        }
    }

    private void applyCellStyle(CellStyle cellStyle) {
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
    }

    //엑셀파일을 List<VO>로 컨버팅해줌
    public <T> List<T> ExcelUploadConvert(MultipartFile excel, Class<T> base) throws IOException {
        List<String> baseVarName = new ArrayList<>();
        List<Object> objs = new ArrayList<>();
        for (Field e : base.getDeclaredFields()) {
            baseVarName.add(e.getName());
        }
        Workbook wb = new HSSFWorkbook(excel.getInputStream());
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
            int celSize = sheet.getRow(i).getLastCellNum();
            JSONObject obj = new JSONObject();
            for (int j = 0; j < celSize; j++) {
                obj.put(baseVarName.get(j), sheet.getRow(i).getCell(j));
            }
            objs.add(obj);
        }
        return objs.stream().map(e -> new Gson()
                        .newBuilder()
                        .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context)
                                -> LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                        .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, typeOfT, context)
                                -> LocalDate.parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                        .registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, typeOfT, context)
                                -> LocalTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("HH:mm:ss")))
                        .create()
                        .fromJson(String.valueOf(e), base))
                .collect(Collectors.toList());
    }




}
