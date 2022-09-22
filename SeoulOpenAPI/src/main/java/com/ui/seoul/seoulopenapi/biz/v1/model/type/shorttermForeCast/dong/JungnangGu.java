package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum JungnangGu {

    중랑구("62","128","127","5","41.2","37","36","13.7","127.09477777777778","37.60380555555556"),
    면목제2동("62","127","127","4","52.08","37","35","13.14","127.08113333333333","37.586983333333336"),
    면목제4동("62","127","127","5","15.44","37","34","18.54","127.08762222222222","37.57181666666667"),
    면목제5동("62","127","127","4","54.2","37","34","58.97","127.08172222222221","37.58304722222223"),
    면목본동("62","127","127","5","22.84","37","35","4.42","127.08967777777778","37.584561111111114"),
    면목제7동("62","127","127","5","20.71","37","34","34.32","127.0890861111111","37.5762"),
    면목제8동("62","127","127","5","24.79","37","34","48.85","127.09021944444444","37.58023611111111"),
    면목제3동("62","127","127","5","24.79","37","34","48.85","127.09021944444444","37.58023611111111"),
    상봉제1동("62","127","127","5","21.44","37","35","49.3","127.08928888888889","37.59702777777778"),
    상봉제2동("62","127","127","5","7.4","37","35","22.6","127.08538888888889","37.58961111111111"),
    중화제1동("62","127","127","4","58.0","37","35","54.19","127.08277777777778","37.59838611111111"),
    중화제2동("62","127","127","4","37.28","37","35","31.98","127.07702222222221","37.592216666666666"),
    묵제1동("62","128","127","4","50.11","37","36","34.64","127.0805861111111","37.60962222222222"),
    묵제2동("62","128","127","4","41.32","37","36","24.47","127.07814444444445","37.60679722222223"),
    망우본동("62","127","127","6","30.47","37","35","55.29","127.10846388888888","37.59869166666667"),
    망우제3동("62","127","127","6","0.96","37","35","22.48","127.10026666666666","37.58957777777778"),
    신내1동("62","128","127","6","5.59","37","36","11.1","127.10155277777777","37.60308333333334"),
    신내2동("62","128","127","5","46.59","37","36","12.35","127.09627499999999","37.603430555555555");


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

    JungnangGu(
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
