package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dongAll;

public enum CastCode {
    POP("강수확률","%"),
    PTY("강수형태","코드값"),
    PCP("1시간 강수량","범주 1 mm"),
    REH("습도","%"),
    SNO("1시간 신적설","범주1 cm"),
    SKY("하늘상태","코드값"),
    TMP("1시간 기온","℃"),
    TMN("일 최저기온","℃"),
    TMX("일 최고기온","℃"),
    UUU("풍속동서성분","m/s"),
    VVV("풍속남북성분","m/s"),
    WAV("파고","M"),
    VEC("풍향","deg"),
    WSD("풍속","m/s"),
    T1H("기온","℃"),
    RN1("1시간 강수량","mm");

    private String descrip;
    private String valueType;

    CastCode(String descrip, String valueType) {
        this.descrip = descrip;
        this.valueType = valueType;
    }

    public String getDescrip() {
        return this.descrip;
    }

    public String getValueType() {
        return this.valueType;
    }

    public String getName(){
        return name();
    }
}
