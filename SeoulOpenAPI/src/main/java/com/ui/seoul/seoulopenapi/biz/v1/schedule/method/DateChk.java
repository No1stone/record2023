package com.ui.seoul.seoulopenapi.biz.v1.schedule.method;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateChk {
    private DateTimeFormatter dateFomat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    public boolean dateAfter(String date){
        //지나면 true
        //안지나면 false
        return LocalDateTime.now().isAfter(LocalDateTime.parse(date, dateFomat));
    }

}
