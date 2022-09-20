package com.ui.seoul.seoulopenapi.biz.v1.model.type;

public enum DustGuCode {

    종로구(111123),
    중구(111121),
    용산구(111131),
    성동구(111142),
    광진구(111141),
    동대문구(111152),
    중랑구(111151),
    성북구(111161),
    강북구(111291),
    도봉구(111171),
    노원구(111311),
    은평구(111181),
    서대문구(111191),
    마포구(111201),
    양천구(111301),
    강서구(111212),
    구로구(111221),
    금천구(111281),
    영등포구(111231),
    동작구(111241),
    관악구(111251),
    서초구(111262),
    강남구(111261),
    송파구(111273),
    강동구(111274);

    private int guCode;

    DustGuCode(int guCode) {
        this.guCode = guCode;
    }

    public int GuCodeGet() {
        return guCode;
    }

}
