package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum SeongbukGu {

    성북구("61","127","127","1","13.2","37","35","10.98","127.02033333333333","37.58638333333334"),
    성북동("60","127","127","0","21.91","37","35","14.79","127.00608611111112","37.58744166666667"),
    삼선동("60","127","127","0","34.4","37","34","58.25","127.00955555555555","37.58284722222223"),
    동선동("61","127","127","1","21.03","37","35","28.6","127.02250833333333","37.59127777777778"),
    돈암제1동("61","127","127","1","41.84","37","36","1.83","127.0282888888889","37.60050833333334"),
    돈암제2동("60","127","127","0","45.76","37","35","42.92","127.01271111111112","37.59525555555556"),
    안암동("61","127","127","1","24.52","37","34","59.01","127.02347777777777","37.583058333333334"),
    보문동("61","127","127","1","29.64","37","34","39.32","127.0249","37.57758888888889"),
    정릉제1동("60","127","127","1","7.47","37","35","55.11","127.01874166666667","37.598641666666666"),
    정릉제2동("60","127","127","0","47.67","37","36","6.0","127.01324166666667","37.60166666666667"),
    정릉제3동("60","128","127","0","22.64","37","36","22.2","127.00628888888889","37.60616666666667"),
    정릉제4동("60","128","127","0","29.55","37","36","38.83","127.00820833333333","37.61078611111111"),
    길음제1동("61","127","127","1","27.0","37","36","6.42","127.02416666666666","37.60178333333334"),
    길음제2동("61","128","127","1","45.84","37","36","13.86","127.0294","37.60385"),
    종암동("61","127","127","2","0.79","37","35","50.39","127.03355277777777","37.59733055555556"),
    월곡제1동("61","128","127","2","10.11","37","36","15.13","127.03614166666667","37.60420277777778"),
    월곡제2동("61","127","127","2","30.08","37","35","59.79","127.04168888888888","37.599941666666666"),
    장위제1동("61","128","127","2","45.08","37","36","40.29","127.04585555555555","37.61119166666667"),
    장위제2동("61","128","127","3","24.15","37","36","34.79","127.05670833333333","37.60966388888889"),
    장위제3동("61","128","127","3","31.4","37","36","49.58","127.05872222222222","37.613772222222224"),
    석관동("61","128","127","3","48.67","37","36","36.58","127.06351944444444","37.61016111111111");


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

    SeongbukGu(
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
