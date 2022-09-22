package com.jws.wonseok.config.common;

import com.jws.wonseok.biz.v1.EnumTestModel.EnumMapperType;
import com.jws.wonseok.biz.v1.EnumTestModel.EnumMapperValue;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnumMapper1 {

        private Map<String, List<EnumMapperValue>> factory = new LinkedHashMap<>();

    public EnumMapper1() {
    }

    public void put(String key, Class<? extends EnumMapperType> e) {
        factory.put(key, toEnumValue(e));
    }


    private List<EnumMapperValue> toEnumValue(Class<? extends EnumMapperType> e) {
        return Arrays.stream(e.getEnumConstants())
                .map(EnumMapperValue::new)
                .collect(Collectors.toList());
    }


    public List<EnumMapperValue> get(String key) {
        return factory.get(key);
    }

}
