package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum JongnoGu {

    종로구("60","127","126","58","53.91","37","34","13.36","126.98164166666668","37.57037777777778"),
    청운효자동("60","127","126","58","14.35","37","35","2.89","126.9706519","37.5841367"),
    사직동("60","127","126","58","15.44","37","34","23.77","126.97095555555556","37.57326944444445"),
    삼청동("60","127","126","59","2.32","37","34","56.73","126.98397777777778","37.582425"),
    부암동("60","127","126","57","59.2","37","35","23.48","126.96644444444445","37.58985555555556"),
    평창동("60","127","126","58","7.96","37","36","9.08","126.96887777777778","37.60252222222223"),
    무악동("60","127","126","57","40.35","37","34","17.54","126.96120833333333","37.571538888888895"),
    교남동("60","127","126","57","50.76","37","34","8.67","126.9641","37.569075000000005"),
    가회동("60","127","126","59","12.88","37","34","38.11","126.98691111111111","37.57725277777778"),
    종로1가동("60","127","126","59","27.84","37","34","4.39","126.99106666666667","37.567886111111115"),
    종로2가동("60","127","126","59","27.84","37","34","4.39","126.99106666666667","37.567886111111115"),
    종로3가동("60","127","126","59","27.84","37","34","4.39","126.99106666666667","37.567886111111115"),
    종로4가동("60","127","126","59","27.84","37","34","4.39","126.99106666666667","37.567886111111115"),
    종로5가동("60","127","127","0","25.76","37","34","9.16","127.00715555555556","37.569211111111116"),
    종로6가동("60","127","127","0","25.76","37","34","9.16","127.00715555555556","37.569211111111116"),
    이화동("60","127","127","0","23.03","37","34","27.17","127.00639722222222","37.57421388888889"),
    혜화동("60","127","127","0","9.44","37","35","2.36","127.00262222222223","37.58398888888889"),
    창신제1동("61","127","127","1","6.47","37","34","4.57","127.01846388888889","37.567936111111116"),
    창신제2동("60","127","127","0","46.67","37","34","17.92","127.01296388888889","37.571644444444445"),
    창신제3동("60","127","127","1","1.79","37","34","30.17","127.01716388888889","37.575047222222224"),
    숭인제1동("60","127","127","1","3.59","37","34","30.1","127.01766388888889","37.575027777777784"),
    숭인제2동("61","127","127","1","19.4","37","34","19.33","127.02205555555555","37.57203611111112");

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

    JongnoGu(
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
