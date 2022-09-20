package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum YeongdeungpoGu {

    영등포구("58","126","126","53","54.03","37","31","25.0","126.89834166666667","37.52361111111111"),
    영등포본동("59","126","0","0","0.0","0","0","0.0","126.9093046","37.5146826"),
    영등포동("59","126","0","0","0.0","0","0","0.0","126.910691","37.5203985"),
    여의동("59","126","126","56","12.32","37","30","53.6","126.93675555555556","37.51488888888889"),
    당산제1동("58","126","126","53","58.28","37","31","19.77","126.89952222222223","37.52215833333333"),
    당산제2동("59","126","126","54","15.28","37","31","54.98","126.90424444444444","37.53193888888889"),
    도림동("59","125","0","0","0.0","0","0","0.0","126.89595","37.509475"),
    문래동("59","126","0","0","0.0","0","0","0.0","126.8995421","37.5170965"),
    양평제1동("58","126","126","53","25.03","37","31","15.05","126.89028611111112","37.52084722222222"),
    양평제2동("58","126","126","53","52.88","37","32","6.0","126.89802222222222","37.535"),
    신길제1동("59","125","126","55","24.52","37","30","29.42","126.92347777777778","37.50817222222222"),
    신길제3동("59","125","126","54","35.71","37","30","16.64","126.90991944444445","37.504622222222224"),
    신길제4동("59","125","126","54","48.15","37","30","20.42","126.913375","37.50567222222222"),
    신길제5동("59","125","126","54","26.44","37","29","55.76","126.90734444444445","37.49882222222222"),
    신길제6동("59","125","126","54","43.0","37","29","47.63","126.91194444444444","37.49656388888889"),
    신길제7동("59","125","126","55","24.52","37","30","13.16","126.92347777777778","37.503655555555554"),
    대림제1동("59","125","126","54","28.67","37","29","33.32","126.9079638888889","37.49258888888889"),
    대림제2동("58","125","126","54","1.28","37","29","23.73","126.90035555555556","37.489925"),
    대림제3동("58","125","126","54","0.76","37","29","43.75","126.90021111111112","37.49548611111111");


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

    YeongdeungpoGu(
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
