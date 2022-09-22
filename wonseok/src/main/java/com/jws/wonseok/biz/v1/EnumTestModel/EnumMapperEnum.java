package com.jws.wonseok.biz.v1.EnumTestModel;

public enum EnumMapperEnum implements EnumMapperType{

    PERCENT("퍼센트"),
    MONEY("돈");

    private String title;

    EnumMapperEnum(String title){
        this.title = title;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }

}
