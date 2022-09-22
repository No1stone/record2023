package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum EunpyeongGu {

    은평구("59","127","126","55","52.47","37","35","59.89","126.93124166666666","37.59996944444445"),
    녹번동("59","127","126","56","12.64","37","35","59.86","126.93684444444445","37.599961111111114"),
    불광제1동("59","128","126","56","3.08","37","36","27.13","126.9341888888889","37.60753611111111"),
    불광제2동("59","128","126","55","47.35","37","37","7.66","126.92981944444445","37.61879444444445"),
    갈현제1동("59","128","126","55","7.64","37","37","15.23","126.9187888888889","37.620897222222226"),
    갈현제2동("59","128","126","55","4.4","37","36","56.76","126.9178888888889","37.615766666666666"),
    구산동("59","128","126","54","45.0","37","36","32.47","126.91250000000001","37.60901944444445"),
    대조동("59","128","126","55","22.4","37","36","40.82","126.92288888888889","37.61133888888889"),
    응암제1동("59","127","126","55","43.91","37","35","52.48","126.9288638888889","37.59791111111112"),
    응암제2동("59","127","126","55","30.47","37","35","30.54","126.92513055555555","37.591816666666666"),
    응암제3동("59","127","126","55","4.23","37","35","21.79","126.91784166666667","37.58938611111111"),
    역촌동("59","127","126","55","2.2","37","36","5.83","126.91727777777778","37.601619444444445"),
    신사제1동("59","127","126","54","51.79","37","35","42.79","126.91438611111111","37.595219444444446"),
    신사제2동("59","127","126","54","53.4","37","35","21.6","126.91483333333333","37.589333333333336"),
    증산동("59","127","126","54","33.2","37","34","53.51","126.90922222222223","37.58153055555556"),
    수색동("58","127","126","53","58.71","37","34","52.89","126.89964166666667","37.581358333333334"),
    진관동("59","128","126","55","16.0","37","38","8.16","126.92111111111112","37.6356");



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

    EunpyeongGu(
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
