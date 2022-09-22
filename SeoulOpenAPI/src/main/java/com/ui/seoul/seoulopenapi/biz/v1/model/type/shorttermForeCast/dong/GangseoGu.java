package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum GangseoGu {

    강서구("58","126","126","51","6.03","37","32","53.36","126.851675","37.54815555555555"),
    염창동("58","126","126","52","22.96","37","33","3.76","126.87304444444443","37.55104444444444"),
    등촌제1동("58","126","126","51","39.59","37","33","11.04","126.86099722222221","37.553066666666666"),
    등촌제2동("58","126","126","51","52.55","37","32","23.47","126.86459722222222","37.539852777777774"),
    등촌제3동("58","126","126","51","0.03","37","33","21.94","126.85000833333332","37.55609444444444"),
    화곡제1동("58","126","126","50","37.47","37","31","39.88","126.84374166666666","37.527744444444444"),
    화곡제2동("58","126","126","51","24.28","37","31","43.64","126.85674444444444","37.52878888888889"),
    화곡제3동("57","126","126","50","25.67","37","32","23.79","126.84046388888889","37.539941666666664"),
    화곡제4동("58","126","126","51","54.84","37","31","48.48","126.86523333333332","37.53013333333333"),
    화곡본동("58","126","126","50","59.11","37","32","28.48","126.84975277777777","37.541244444444445"),
    화곡제6동("58","126","126","51","8.08","37","32","56.38","126.85224444444444","37.54899444444444"),
    화곡제8동("58","126","126","51","1.52","37","31","47.61","126.85042222222222","37.529891666666664"),
    가양제1동("57","127","126","50","33.59","37","33","59.32","126.84266388888888","37.56647777777778"),
    가양제2동("58","127","126","51","12.11","37","33","52.58","126.85336388888888","37.56460555555555"),
    가양제3동("58","127","126","51","45.67","37","33","29.79","126.8626861111111","37.558274999999995"),
    발산제1동("57","126","126","50","6.88","37","33","0.97","126.83524444444444","37.55026944444444"),
    우장산동("58","126","0","0","0.0","0","0","0.0","126.8418849","37.5482468"),
    공항동("57","126","126","48","43.79","37","33","21.98","126.81216388888889","37.556105555555554"),
    방화제1동("57","127","126","48","51.52","37","34","7.58","126.81431111111111","37.56877222222222"),
    방화제2동("57","127","126","48","31.79","37","33","49.95","126.80883055555556","37.563874999999996"),
    방화제3동("57","127","126","48","57.67","37","34","33.39","126.81601944444444","37.57594166666667");


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

    GangseoGu(
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
