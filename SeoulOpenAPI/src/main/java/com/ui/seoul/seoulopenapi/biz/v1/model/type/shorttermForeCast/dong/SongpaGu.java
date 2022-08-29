package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum SongpaGu {

    송파구("62","126","127","6","28.55","37","30","42.32","127.10793055555555","37.51175555555555"),
    풍납1동("62","126","127","7","27.28","37","32","6.89","127.12424444444444","37.53524722222222"),
    풍납2동("62","126","127","7","7.91","37","31","33.42","127.11886388888888","37.52595"),
    거여1동("63","125","127","8","43.47","37","29","38.79","127.14540833333334","37.49410833333334"),
    거여2동("63","125","127","8","56.4","37","29","26.47","127.149","37.49068611111111"),
    마천1동("63","125","127","9","7.52","37","29","35.6","127.1520888888889","37.49322222222222"),
    마천2동("63","125","127","9","2.44","37","29","38.67","127.15067777777779","37.494075"),
    방이1동("62","125","127","7","33.64","37","30","29.33","127.12601111111111","37.50814722222222"),
    방이2동("62","126","127","6","59.52","37","30","42.32","127.11653333333332","37.51175555555555"),
    오륜동("63","126","127","8","11.4","37","30","45.32","127.13650000000001","37.51258888888889"),
    오금동("62","125","127","7","48.88","37","30","0.54","127.13024444444444","37.50015"),
    송파1동("62","125","127","6","42.55","37","30","11.27","127.11181944444444","37.50313055555556"),
    송파2동("62","125","127","7","8.08","37","29","57.97","127.1189111111111","37.49943611111111"),
    석촌동("62","125","127","6","20.71","37","30","2.79","127.10575277777777","37.500775"),
    삼전동("62","125","127","5","40.71","37","29","59.92","127.09464166666666","37.49997777777778"),
    가락본동("62","125","127","7","26.08","37","29","33.98","127.1239111111111","37.49277222222222"),
    가락1동("62","125","127","6","27.67","37","29","37.5","127.10768611111111","37.49375"),
    가락2동("62","125","127","7","43.11","37","29","45.04","127.12864166666667","37.495844444444444"),
    문정1동("62","125","127","7","34.32","37","29","13.89","127.1262","37.48719166666667"),
    문정2동("62","125","127","6","47.03","37","29","13.39","127.11306388888889","37.48705277777778"),
    장지동("63","125","127","8","4.32","37","29","2.89","127.13453333333334","37.48413611111111"),
    위례동("63","125","127","8","29.37","37","28","44.996","127.1414918","37.4791657"),
    잠실본동("62","125","127","5","11.11","37","30","12.08","127.08641944444445","37.50335555555556"),
    잠실2동("62","126","127","5","23.91","37","30","42.89","127.089975","37.51191388888889"),
    잠실3동("62","125","127","5","47.08","37","30","16.16","127.09641111111111","37.504488888888886"),
    잠실4동("62","126","127","6","36.2","37","30","59.2","127.11005555555555","37.516444444444446"),
    잠실6동("62","126","127","6","9.55","37","30","55.38","127.10265277777778","37.51538333333333"),
    잠실7동("62","125","127","4","44.88","37","30","21.1","127.07913333333333","37.50586111111111");


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

    SongpaGu(
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
