package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum SeochoGu {

    서초구("61","125","127","2","5.32","37","28","50.83","127.03481111111111","37.480786111111115"),
    서초1동("61","125","127","1","16.0","37","29","9.6","127.02111111111111","37.486000000000004"),
    서초2동("61","125","127","1","36.88","37","29","21.3","127.0269111111111","37.48925"),
    서초3동("60","125","127","0","52.44","37","28","50.82","127.01456666666667","37.480783333333335"),
    서초4동("61","125","127","1","27.2","37","29","59.48","127.02422222222222","37.499855555555555"),
    잠원동("60","126","127","0","57.79","37","30","43.52","127.01605277777777","37.51208888888889"),
    반포본동("60","125","126","59","17.28","37","29","51.54","126.98813333333334","37.49765"),
    반포1동("60","125","127","0","52.08","37","30","11.95","127.01446666666666","37.50331944444444"),
    반포2동("60","125","126","59","47.67","37","30","6.42","126.996575","37.501783333333336"),
    반포3동("60","125","127","0","27.91","37","30","33.02","127.00775277777778","37.50917222222222"),
    반포4동("60","125","127","0","8.79","37","29","41.13","127.00244166666667","37.49475833333334"),
    방배본동("60","125","126","59","27.0","37","29","29.2","126.99083333333333","37.49144444444445"),
    방배1동("60","125","126","59","47.79","37","28","50.01","126.99660833333333","37.480558333333335"),
    방배2동("60","125","126","59","15.4","37","28","37.08","126.98761111111111","37.47696666666667"),
    방배3동("60","125","127","0","4.08","37","28","39.14","127.00113333333333","37.477538888888894"),
    방배4동("60","125","126","59","35.96","37","29","12.54","126.99332222222222","37.48681666666667"),
    양재1동("61","125","127","2","17.35","37","28","53.89","127.03815277777778","37.481636111111115"),
    양재2동("61","125","127","2","35.32","37","28","4.01","127.04314444444444","37.46778055555556"),
    내곡동("61","124","127","3","12.28","37","27","32.92","127.0534111111111","37.45914444444445");


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

    SeochoGu(
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
