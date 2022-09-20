package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum MapoGu {

    마포구("59","127","126","54","37.91","37","33","38.54","126.91053055555557","37.56070555555555"),
    아현동("59","126","126","57","15.2","37","32","39.64","126.95422222222223","37.54434444444444"),
    공덕동("60","126","126","57","43.52","37","32","50.79","126.96208888888889","37.547441666666664"),
    도화동("59","126","126","57","7.67","37","32","5.64","126.95213055555556","37.5349"),
    용강동("59","126","126","56","37.44","37","32","21.29","126.94373333333334","37.53924722222222"),
    대흥동("59","126","126","56","41.32","37","33","10.98","126.94481111111112","37.55305"),
    염리동("59","126","126","56","51.79","37","32","39.79","126.94771944444445","37.54438611111111"),
    신수동("59","126","126","56","11.91","37","32","38.64","126.93664166666667","37.544066666666666"),
    서강동("59","126","126","56","2.96","37","32","40.01","126.93415555555556","37.54444722222222"),
    서교동("59","126","126","55","22.71","37","32","58.76","126.92297500000001","37.54965555555555"),
    합정동("59","126","126","54","27.91","37","32","48.2","126.90775277777779","37.54672222222222"),
    망원제1동("59","126","126","54","27.96","37","33","8.76","126.90776666666667","37.55243333333333"),
    망원제2동("59","126","126","54","15.52","37","33","27.23","126.90431111111111","37.557563888888886"),
    연남동("59","127","126","55","26.64","37","33","42.1","126.92406666666668","37.56169444444444"),
    성산제1동("59","127","126","54","36.08","37","33","38.1","126.91002222222222","37.560583333333334"),
    성산제2동("59","127","126","54","40.15","37","33","57.35","126.91115277777779","37.56593055555555"),
    상암동("58","127","126","53","48.52","37","34","31.85","126.89681111111112","37.57551388888889");


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

    MapoGu(
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
