package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum DongjakGu {

    동작구("59","125","126","56","29.67","37","30","34.76","126.941575","37.509655555555554"),
    노량진제1동("59","125","126","56","38.71","37","30","34.13","126.94408611111112","37.509480555555555"),
    노량진제2동("59","125","126","56","21.79","37","30","20.64","126.93938611111112","37.50573333333333"),
    상도제1동("59","125","126","57","10.88","37","30","14.58","126.95302222222223","37.50405"),
    상도제2동("59","125","126","56","39.84","37","30","9.51","126.9444","37.50264166666667"),
    상도제3동("59","125","126","56","0.2","37","29","46.92","126.9333888888889","37.49636666666667"),
    상도제4동("59","125","126","56","23.55","37","29","52.0","126.939875","37.49777777777778"),
    흑석동("60","125","126","57","45.4","37","30","24.26","126.96261111111112","37.50673888888889"),
    사당제1동("60","125","126","58","32.64","37","28","25.0","126.97573333333334","37.47361111111111"),
    사당제2동("60","125","126","58","46.23","37","29","8.23","126.97950833333334","37.485619444444445"),
    사당제3동("60","125","126","58","26.71","37","29","1.77","126.97408611111112","37.483825"),
    사당제4동("60","125","126","58","25.4","37","28","41.47","126.97372222222222","37.478186111111114"),
    사당제5동("60","125","126","58","8.79","37","28","58.07","126.96910833333334","37.482797222222224"),
    대방동("59","125","126","55","42.4","37","30","19.19","126.92844444444445","37.50533055555555"),
    신대방제1동("59","125","126","54","43.59","37","29","10.14","126.91210833333334","37.48615"),
    신대방제2동("59","125","126","55","40.71","37","29","46.04","126.927975","37.496122222222226");



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

    DongjakGu(
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
