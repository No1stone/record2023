package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum YangcheonGu {

    양천구("58","126","126","52","7.35","37","30","51.23","126.86870833333333","37.51423055555556"),
    목1동("58","126","126","52","23.64","37","31","39.14","126.87323333333333","37.52753888888889"),
    목2동("58","126","126","52","25.71","37","32","36.07","126.87380833333333","37.54335277777778"),
    목3동("58","126","126","51","59.76","37","32","31.55","126.86659999999999","37.54209722222222"),
    목4동("58","126","126","52","13.79","37","31","46.32","126.87049722222221","37.52953333333333"),
    목5동("58","126","126","52","50.71","37","31","56.7","126.88075277777777","37.53241666666666"),
    신월1동("57","126","126","50","0.96","37","31","48.02","126.83359999999999","37.530005555555555"),
    신월2동("58","126","126","50","47.71","37","31","19.82","126.84658611111111","37.522172222222224"),
    신월3동("57","126","126","49","52.23","37","31","51.05","126.831175","37.53084722222222"),
    신월4동("57","126","126","50","31.76","37","31","18.86","126.84215555555555","37.521905555555556"),
    신월5동("57","126","126","49","46.0","37","32","12.8","126.82944444444443","37.53688888888889"),
    신월6동("58","126","126","50","44.76","37","30","47.89","126.84576666666666","37.51330277777778"),
    신월7동("57","126","126","50","12.35","37","31","8.73","126.83676388888888","37.51909166666667"),
    신정1동("58","126","126","51","23.03","37","30","56.63","126.85639722222221","37.51573055555556"),
    신정2동("58","126","126","52","21.71","37","30","59.07","126.87269722222221","37.51640833333333"),
    신정3동("58","126","126","51","24.79","37","30","44.41","126.85688611111111","37.51233611111111"),
    신정4동("58","126","126","51","38.88","37","31","14.29","126.8608","37.52063611111111"),
    신정6동("58","126","126","51","59.35","37","30","51.29","126.8664861111111","37.514247222222224"),
    신정7동("58","125","126","51","42.32","37","30","41.76","126.86175555555555","37.5116");


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

    YangcheonGu(
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
