package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum GwangjinGu {

    광진구("62","126","127","5","4.32","37","32","8.66","127.08453333333333","37.535738888888886"),
    화양동("61","126","127","4","24.47","37","32","37.63","127.07346388888888","37.54378611111111"),
    군자동("62","126","127","4","40.79","37","33","8.47","127.07799722222222","37.55235277777778"),
    중곡제1동("62","127","127","4","55.79","37","33","28.23","127.08216388888889","37.55784166666666"),
    중곡제2동("62","127","127","5","0.76","37","33","26.91","127.08354444444444","37.557475"),
    중곡제3동("62","127","127","4","56.11","37","33","57.3","127.08225277777777","37.565916666666666"),
    중곡제4동("62","127","127","5","21.67","37","33","45.04","127.08935277777778","37.56251111111111"),
    능동("62","126","127","4","57.52","37","33","3.7","127.08264444444444","37.551027777777776"),
    광장동("62","126","127","6","19.11","37","32","39.17","127.10530833333333","37.54421388888888"),
    자양제1동("62","126","127","5","3.91","37","31","54.07","127.08441944444444","37.53168611111111"),
    자양제2동("62","126","127","5","11.76","37","31","33.6","127.08659999999999","37.525999999999996"),
    자양제3동("61","126","127","4","30.11","37","31","51.72","127.07503055555556","37.53103333333333"),
    자양제4동("61","126","127","4","2.11","37","32","14.95","127.06725277777777","37.53748611111111"),
    구의제1동("62","126","127","5","16.32","37","32","22.83","127.08786666666666","37.539674999999995"),
    구의제2동("62","126","127","5","31.59","37","32","39.98","127.09210833333333","37.544438888888884"),
    구의제3동("62","126","127","5","58.88","37","32","10.1","127.09968888888888","37.536138888888885");


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

    GwangjinGu(
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
