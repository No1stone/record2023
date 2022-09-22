package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum GuroGu {

    구로구("58","125","126","53","22.55","37","29","33.54","126.88959722222224","37.49265"),
    신도림동("58","125","126","52","57.55","37","30","17.92","126.88265277777776","37.504977777777775"),
    구로제1동("58","125","126","52","40.28","37","29","24.73","126.87785555555556","37.49020277777778"),
    구로제2동("58","125","126","53","8.4","37","29","18.97","126.88566666666668","37.48860277777778"),
    구로제3동("58","125","126","53","44.47","37","28","59.0","126.89568611111112","37.48305555555556"),
    구로제4동("58","125","126","53","28.4","37","29","19.79","126.89122222222223","37.48883055555556"),
    구로제5동("58","125","126","53","28.96","37","29","50.2","126.89137777777779","37.49727777777778"),
    가리봉동("58","125","126","53","31.15","37","28","40.73","126.89198611111112","37.477980555555554"),
    고척제1동("58","125","126","51","53.28","37","29","51.39","126.86479999999999","37.49760833333333"),
    고척제2동("58","125","126","51","37.55","37","30","13.6","126.86043055555555","37.50377777777778"),
    개봉제1동("58","125","126","50","57.35","37","29","57.79","126.84926388888888","37.499386111111114"),
    개봉제2동("58","125","126","51","31.03","37","29","16.89","126.85861944444444","37.488025"),
    개봉제3동("58","125","126","51","21.2","37","28","59.42","126.85588888888888","37.48317222222222"),
    오류제1동("58","125","126","50","49.52","37","29","39.29","126.84708888888889","37.49424722222222"),
    오류제2동("57","125","126","50","29.79","37","29","9.57","126.84160833333333","37.48599166666667"),
    수궁동("57","125","126","50","0.84","37","29","27.98","126.83356666666666","37.491105555555556"),
    항동("57","125","126","48","38.5758000000021","37","28","55.826400000002","126.8107155","37.482174");


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

    GuroGu(
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
