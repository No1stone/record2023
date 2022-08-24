package com.jws.wonseok.config.common;

import com.jws.wonseok.biz.v1.EnumTestModel.EnumMapperType;
import com.jws.wonseok.biz.v1.EnumTestModel.EnumMapperValue;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnumMapper2 {

    private Map<String, Map<String, String>> factory = new LinkedHashMap<>();

    public EnumMapper2() {
    }


    public void put(String key, Class<? extends EnumMapperType> e) {
        factory.put(key, toEnumValue(e));
    }


    private Map<String, String> toEnumValue(Class<? extends EnumMapperType> e) {
        return Arrays.stream(e.getEnumConstants())
                .collect(Collectors.toMap(EnumMapperType::getCode, EnumMapperType::getTitle));
    }

    public Map<String, String> get(String key) {
        return factory.get(key);
    }

}
