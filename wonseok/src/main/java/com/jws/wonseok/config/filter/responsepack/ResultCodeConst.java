package com.jws.wonseok.config.filter.responsepack;

public enum ResultCodeConst {
    //공통처리
    SUCCESS("0000"),
    NOT_FOUND_INFO("0010"),

    //valid
    NOT_EXIST_PROFILE_ID("1200"),
    NOT_FOUND_PROJECT_ID("5010"),
    NOT_VALID_COMPANY_CD("1100"),
    NOT_VALID_SONG_ID("3401"),
    BAD_REQUEST_EMAIL_ID("3102"),

    //Fail
    FAIL("2000"),

    //System Error
    ERROR("9999");
    private String code;

    ResultCodeConst(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
