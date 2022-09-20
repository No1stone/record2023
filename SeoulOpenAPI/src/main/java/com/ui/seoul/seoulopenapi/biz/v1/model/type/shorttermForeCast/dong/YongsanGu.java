package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum YongsanGu {

    용산구("60","126","126","58","3.08","37","32","9.94","126.96752222222223","37.536094444444444"),
    후암동("60","126","126","58","48.96","37","32","45.17","126.98026666666667","37.545880555555556"),
    용산2가동("60","126","126","59","15.23","37","32","35.23","126.98756388888889","37.54311944444444"),
    남영동("60","126","126","58","37.08","37","32","34.2","126.97696666666667","37.542833333333334"),
    청파동("60","126","126","58","19.35","37","32","33.2","126.97204166666667","37.54255555555555"),
    원효로제1동("60","126","126","58","6.03","37","32","9.13","126.96834166666667","37.535869444444444"),
    원효로제2동("59","126","126","57","12.88","37","31","53.73","126.95357777777778","37.531591666666664"),
    효창동("60","126","126","57","48.23","37","32","20.23","126.96339722222223","37.53895277777777"),
    용문동("60","126","126","57","34.79","37","32","10.5","126.9596638888889","37.536249999999995"),
    한강로동("60","126","126","58","17.52","37","31","34.47","126.97153333333334","37.526241666666664"),
    이촌제1동("60","126","126","58","31.28","37","31","6.25","126.97535555555555","37.51840277777778"),
    이촌제2동("59","126","126","57","22.79","37","31","26.51","126.95633055555555","37.524030555555555"),
    이태원제1동("60","126","126","59","49.35","37","31","46.17","126.99704166666666","37.529491666666665"),
    이태원제2동("60","126","126","59","30.64","37","32","16.7","126.99184444444444","37.53797222222222"),
    한남동("60","126","127","0","9.52","37","31","54.79","127.00264444444444","37.53188611111111"),
    서빙고동("60","126","126","59","48.4","37","31","3.38","126.99677777777778","37.517605555555555"),
    보광동("60","126","127","0","8.4","37","31","24.47","127.00233333333334","37.52346388888889");

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

    YongsanGu(
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
