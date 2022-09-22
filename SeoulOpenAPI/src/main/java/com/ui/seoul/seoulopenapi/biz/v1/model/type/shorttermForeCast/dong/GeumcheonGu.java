package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum GeumcheonGu {

    금천구("59","124","126","54","15.11","37","26","56.79","126.90419722222222","37.44910833333333"),
    가산동("58","125","126","53","37.71","37","28","26.85","126.89380833333334","37.474125"),
    독산제1동("58","125","126","53","56.76","37","28","2.85","126.8991","37.46745833333333"),
    독산제2동("59","124","126","54","6.64","37","27","47.86","126.90184444444445","37.46329444444445"),
    독산제3동("59","125","126","54","35.96","37","28","25.64","126.90998888888889","37.47378888888889"),
    독산제4동("59","124","126","54","15.2","37","27","52.76","126.90422222222223","37.46465555555556"),
    시흥제1동("58","124","126","53","57.91","37","27","7.73","126.89941944444445","37.45214722222222"),
    시흥제2동("59","124","126","55","7.79","37","26","50.25","126.91883055555556","37.447291666666665"),
    시흥제3동("59","124","126","54","28.71","37","26","15.07","126.90797500000001","37.43751944444444"),
    시흥제4동("59","124","126","54","29.67","37","27","22.23","126.90824166666667","37.456175"),
    시흥제5동("59","124","126","54","37.47","37","26","58.51","126.91040833333334","37.44958611111111");


    private String gridx;
    private String gridy;
    private String longitudecity;
    private String longitudeminutes;
    private String longitudeseconds;
    private String latitudecity;
    private String latitudeminutes;
    private String latitudeseconds;
    private String longitudeseconds100;
    private String latitudeseconds100;

    GeumcheonGu(
            String gridx,
            String gridy,
            String longitudecity,
            String longitudeminutes,
            String longitudeseconds,
            String latitudecity,
            String latitudeminutes,
            String latitudeseconds,
            String longitudeseconds100,
            String latitudeseconds100
    ) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.longitudecity = longitudecity;
        this.longitudeminutes = longitudeminutes;
        this.longitudeseconds = longitudeseconds;
        this.latitudecity = latitudecity;
        this.latitudeminutes = latitudeminutes;
        this.latitudeseconds = latitudeseconds;
        this.longitudeseconds100 = longitudeseconds100;
        this.latitudeseconds100 = latitudeseconds100;
    }

    public String getgridx() {
        return this.gridx;
    }

    public String getgridy() {
        return this.gridy;
    }

    public String getlongitudecity() {
        return this.longitudecity;
    }

    public String getlongitudeminutes() {
        return this.longitudeminutes;
    }

    public String getlongitudeseconds() {
        return this.longitudeseconds;
    }

    public String getlatitudecity() {
        return this.latitudecity;
    }

    public String getlatitudeminutes() {
        return this.latitudeminutes;
    }

    public String getlatitudeseconds() {
        return this.latitudeseconds;
    }

    public String getlongitudeseconds100() {
        return this.longitudeseconds100;
    }

    public String getlatitudeseconds100() {
        return this.latitudeseconds100;
    }


}
