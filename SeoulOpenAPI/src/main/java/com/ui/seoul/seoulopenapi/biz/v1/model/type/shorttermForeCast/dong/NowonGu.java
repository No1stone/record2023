package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum NowonGu {

    노원구("61","129","127","3","30.2","37","39","5.26","127.05838888888889","37.65146111111111"),
    월계1동("61","128","127","3","54.32","37","37","2.35","127.06508888888888","37.61731944444445"),
    월계2동("61","128","127","3","10.79","37","37","47.14","127.05299722222222","37.62976111111111"),
    월계3동("61","128","127","4","16.79","37","37","5.54","127.07133055555555","37.618205555555555"),
    공릉1동("61","128","127","4","25.51","37","37","29.02","127.0737518","37.62472748"),
    공릉2동("62","128","127","5","7.59","37","37","6.85","127.08544166666667","37.61856944444445"),
    하계1동("61","128","127","4","29.03","37","38","16.02","127.07473055555555","37.63778333333333"),
    하계2동("61","128","127","4","12.4","37","37","45.3","127.0701111111111","37.62925"),
    중계본동("62","128","127","4","56.84","37","38","42.26","127.08245555555555","37.64507222222222"),
    중계1동("62","129","127","4","46.79","37","38","59.23","127.07966388888889","37.64978611111111"),
    중계4동("62","129","127","4","48.32","37","39","21.48","127.08008888888888","37.655966666666664"),
    중계2동("61","128","0","0","0.0","0","0","0.0","127.0687126","37.6421829"),
    중계3동("61","128","0","0","0.0","0","0","0.0","127.0687126","37.6421829"),
    상계1동("61","129","127","3","25.96","37","40","37.57","127.0572111111111","37.677102777777776"),
    상계2동("61","129","127","4","14.55","37","39","21.51","127.07070833333333","37.655975"),
    상계3동("61","129","127","4","38.88","37","39","39.6","127.07746666666667","37.661"),
    상계4동("61","129","127","4","38.88","37","39","39.6","127.07746666666667","37.661"),
    상계5동("61","129","127","4","17.35","37","39","36.79","127.07148611111111","37.660219444444444"),
    상계6동("61","129","127","4","8.64","37","39","7.52","127.06906666666666","37.65208888888889"),
    상계7동("61","129","127","4","8.64","37","39","7.52","127.06906666666666","37.65208888888889"),
    상계8동("61","129","127","3","13.2","37","39","50.2","127.05366666666666","37.663944444444446"),
    상계9동("61","129","127","3","57.44","37","39","42.16","127.06595555555555","37.66171111111111"),
    상계10동("61","129","127","3","44.52","37","39","30.36","127.06236666666666","37.658433333333335");

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

    NowonGu(
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
