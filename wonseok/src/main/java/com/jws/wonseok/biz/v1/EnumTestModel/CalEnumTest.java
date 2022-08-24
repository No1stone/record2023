package com.jws.wonseok.biz.v1.EnumTestModel;

import java.util.function.Function;

public enum CalEnumTest {

    cal_a(value -> value),
    cal_b(value -> value + 1000),
    cal_c(value -> value / 2);

    private Function<Long, Long> value;

    CalEnumTest(Function<Long, Long> value){
        this.value = value;
    }

    public Long appCal(Long value){
        return this.value.apply(value);
    }

}
