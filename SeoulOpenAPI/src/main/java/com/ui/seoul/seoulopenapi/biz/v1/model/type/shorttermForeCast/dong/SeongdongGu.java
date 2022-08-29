package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum SeongdongGu {

    성동구("61","127","127","2","20.4","37","33","38.2","127.039","37.56061111111111"),
    왕십리제2동("61","127","127","1","57.76","37","33","30.01","127.03271111111111","37.55833611111111"),
    왕십리도선동("61","127","127","1","32.01","37","34","3.92","127.0255591","37.5677544"),
    마장동("61","127","127","2","51.23","37","33","48.36","127.04756388888889","37.56343333333333"),
    사근동("61","127","127","2","52.64","37","33","30.26","127.04795555555556","37.55840555555555"),
    행당제1동("61","126","127","2","17.08","37","33","19.27","127.03807777777777","37.55535277777778"),
    행당제2동("61","126","127","1","53.52","37","33","20.07","127.03153333333333","37.555575"),
    응봉동("61","126","127","2","7.79","37","33","1.25","127.03549722222222","37.55034722222222"),
    금호1가동("61","126","127","1","26.2","37","33","7.45","127.02394444444444","37.55206944444444"),
    금호2가동("61","126","0","0","0.0","0","0","0.0","127.020859","37.553188"),
    금호3가동("61","126","0","0","0.0","0","0","0.0","127.020859","37.553188"),
    금호4가동("61","126","127","1","28.11","37","32","40.1","127.024475","37.54447222222222"),
    옥수동("60","126","0","0","0.0","0","0","0.0","127.013463","37.543717"),
    성수1가제1동("61","126","127","3","7.15","37","32","20.25","127.0519861111111","37.53895833333333"),
    성수1가제2동("61","126","127","2","46.91","37","32","36.7","127.04636388888889","37.543527777777776"),
    성수2가제1동("61","126","127","3","22.32","37","32","12.13","127.0562","37.536702777777776"),
    성수2가제3동("61","126","127","3","26.4","37","32","43.55","127.05733333333333","37.545430555555555"),
    송정동("61","126","127","4","18.15","37","33","6.22","127.07170833333333","37.55172777777778"),
    용답동("61","127","127","3","26.76","37","33","40.92","127.05743333333334","37.561366666666665");


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

    SeongdongGu(
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
