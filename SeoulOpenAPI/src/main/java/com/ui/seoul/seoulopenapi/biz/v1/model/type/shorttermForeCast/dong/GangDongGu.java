package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum GangDongGu {

    강동구("62","126","127","7","33.11","37","31","38.52","127.12586388888889","37.527366666666666"),
    강일동("63","127","127","10","49.44","37","34","0.17","127.1804","37.56671388888889"),
    상일제1동("63","126","127","10","5.88000000000761","37","33","2.16000000001031","127.1683","37.5506"),
    상일제2동("63","126","127","10","33.239999999995","37","32","59.9999999999898","127.1759","37.55"),
    명일제1동("63","126","127","8","52.88","37","32","49.07","127.14802222222222","37.54696388888889"),
    명일제2동("63","126","127","9","12.4","37","32","36.79","127.15344444444445","37.543552777777776"),
    고덕제1동("63","127","127","9","3.67","37","33","22.48","127.15101944444444","37.55624444444444"),
    고덕제2동("63","127","127","9","59.35","37","33","27.77","127.16648611111111","37.557713888888884"),
    암사제1동("63","126","127","8","5.15","37","32","55.38","127.1347638888889","37.548716666666664"),
    암사제2동("62","126","127","7","45.67","37","32","56.26","127.12935277777777","37.54896111111111"),
    암사제3동("63","126","127","8","25.35","37","33","8.54","127.140375","37.55237222222222"),
    천호제1동("63","126","127","8","19.96","37","32","32.29","127.13887777777778","37.54230277777778"),
    천호제2동("62","126","127","7","22.47","37","32","23.23","127.12290833333333","37.53978611111111"),
    천호제3동("62","126","127","7","55.08","37","32","13.1","127.13196666666666","37.53697222222222"),
    성내제1동("62","126","127","7","33.71","37","31","40.25","127.12603055555554","37.52784722222222"),
    성내제2동("62","126","127","7","53.71","37","31","46.57","127.1315861111111","37.529602777777775"),
    성내제3동("63","126","127","8","5.59","37","31","24.14","127.13488611111111","37.52337222222222"),
    길동("63","126","0","0","0.0","0","0","0.0","127.1461684","37.5392169"),
    둔촌제1동("63","126","127","8","19.79","37","31","14.7","127.13883055555556","37.52075"),
    둔촌제2동("63","126","127","8","38.47","37","31","49.98","127.14401944444445","37.53055");



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

    GangDongGu(
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
