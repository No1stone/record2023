package com.jws.wonseok.config.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.lang.reflect.Field;

@Service
public class YnVerificationModule {
    private final Logger logger = LoggerFactory.getLogger(YnVerificationModule.class);

    //return type 변경해서 사용할것.
    public <T> void verify(T entity) throws IllegalAccessException {
        for (Field f : entity.getClass().getDeclaredFields()) {
            String name = f.getAnnotation(Column.class).name();
            if (name.endsWith("yn")) {
                f.setAccessible(true);
                Object value = f.get(entity);
                //logger.info("column name yn - {}", name);
                //logger.info("name - {}", f.getName());
                //logger.info("value  - {}", value.toString());
            }
        }

    }
}
