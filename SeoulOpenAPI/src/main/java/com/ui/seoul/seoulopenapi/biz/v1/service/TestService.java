package com.ui.seoul.seoulopenapi.biz.v1.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class TestService {

    private final Logger logger = LoggerFactory.getLogger(TestService.class);

    private DateTimeFormatter dateFomat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    public String dateGet() {
        return dateFomat.format(LocalDateTime.now());
    }

    public boolean dateAfter(String date){
        LocalDateTime a1 = LocalDateTime.parse(date, dateFomat);
        boolean aa = LocalDateTime.now().isAfter(a1);
        logger.info("aa - {}",aa);
        return aa;
    }

}
