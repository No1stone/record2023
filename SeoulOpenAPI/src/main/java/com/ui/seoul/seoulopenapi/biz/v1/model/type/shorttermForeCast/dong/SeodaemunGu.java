package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum SeodaemunGu {

    서대문구("59","127","126","56","20.03","37","34","34.92","126.93889722222222","37.57636666666667"),
    천연동("60","127","126","57","40.23","37","34","5.89","126.961175","37.56830277777778"),
    북아현동("59","126","126","57","32.08","37","33","24.73","126.95891111111112","37.556869444444445"),
    충현동("59","127","126","57","24.64","37","33","43.42","126.95684444444444","37.562061111111106"),
    신촌동("59","126","126","56","44.11","37","33","24.26","126.94558611111111","37.55673888888889"),
    연희동("59","127","126","56","14.47","37","34","16.04","126.93735277777778","37.57112222222223"),
    홍제제1동("59","127","126","56","49.15","37","35","5.64","126.94698611111112","37.584900000000005"),
    홍제제3동("59","127","126","57","4.2","37","35","32.8","126.95116666666667","37.592444444444446"),
    홍제제2동("59","127","126","57","5.28","37","35","0.02","126.95146666666668","37.58333888888889"),
    홍은제1동("59","127","126","56","45.44","37","35","25.55","126.94595555555556","37.59043055555556"),
    홍은제2동("59","127","126","56","18.55","37","34","48.57","126.93848611111112","37.58015833333334"),
    남가좌제1동("59","127","126","54","56.08","37","34","16.3","126.91557777777778","37.57119444444445"),
    남가좌제2동("59","127","126","55","33.28","37","34","32.26","126.92591111111112","37.57562777777778"),
    북가좌제1동("59","127","126","54","32.32","37","34","36.16","126.90897777777778","37.576711111111116"),
    북가좌제2동("59","127","126","54","47.59","37","34","42.97","126.91321944444445","37.57860277777778");


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

    SeodaemunGu(
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
