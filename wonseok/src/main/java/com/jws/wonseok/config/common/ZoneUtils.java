package com.jws.wonseok.config.common;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ZoneUtils {
    public static LocalDateTime UTC0(){
       return LocalDateTime.now(ZoneId.of("UTC+0"));
    }

    public static LocalDateTime cumstum(String territory){
        return LocalDateTime.now(ZoneId.of(territory));
    }
}
