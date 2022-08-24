package com.jws.wonseok.biz.v1.EnumTestModel;

import java.util.Arrays;
import java.util.List;

public enum PayGroupAdvanced {

    CASH("현금", Arrays.asList(PayType.ACCOUNT_TRANSPER, PayType.REMITTANCE,PayType.ON_SITE_PAYMENT, PayType.TOSS)),
    CARD("카드",Arrays.asList(PayType.PAYCO, PayType.CARD, PayType.KAKAO_PAY, PayType.BAEMIN_PAY)),
    ETC("기타",Arrays.asList(PayType.POINT, PayType.COUPON)),
    EMPTY("없음",Arrays.asList(PayType.EMPTY));

    private String title;
    private List<PayType> payTypeList;

    PayGroupAdvanced(String title, List<PayType> payTypeList) {
        this.title = title;
        this.payTypeList = payTypeList;
    }

    public static PayGroupAdvanced findByPayType(PayType payType){
        return Arrays.stream(PayGroupAdvanced.values())
                .filter(payGroup -> payGroup.hasPayCode(payType))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasPayCode(PayType payType){
        return payTypeList.stream().anyMatch(pay -> pay == payType);
    }

    public String getTitle(){
        return title;
    }

}
