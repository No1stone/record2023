package com.jws.wonseok.biz.v1.EnumTestModel;

public enum DefaultEnumYn {

    Y("Y", true, "1"),
    N("N", false, "0");

    private String default1;
    private boolean default2;
    private String default3;

    DefaultEnumYn(String default1,boolean default2,String default3){
        this.default1 = default1;
        this.default2 = default2;
        this.default3 = default3;
    }

    public String getDefault1(){
        return default1;
    }
    public boolean getDefault2(){
        return default2;
    }
    public String getDefault3(){
        return default3;
    }

}
