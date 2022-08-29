package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum GangnamGu {

    강남구("61", "126", "127", "2", "58.4", "37", "30", "52.47", "127.04955555555556", "37.514575"),
    신사동("61", "126", "127", "1", "30.08", "37", "31", "16.82", "127.02502222222222", "37.52133888888889"),
    논현1동("61", "125", "127", "1", "49.84", "37", "30", "31.64", "127.03051111111111", "37.50878888888889"),
    논현2동("61", "126", "127", "2", "21.44", "37", "30", "51.97", "127.03928888888889", "37.51443611111111"),
    압구정동("61", "126", "0", "0", "0.0", "0", "0", "0.0", "127.030713", "37.530642"),
    청담동("61", "126", "0", "0", "0.0", "0", "0", "0.0", "127.0493", "37.5251083"),
    삼성1동("61", "125", "127", "3", "27.11", "37", "30", "32.55", "127.05753055555556", "37.50904166666667"),
    삼성2동("61", "125", "127", "2", "53.11", "37", "30", "30.2", "127.0480861111111", "37.50838888888889"),
    대치1동("61", "125", "127", "3", "49.88", "37", "29", "25.82", "127.06385555555555", "37.49050555555556"),
    대치2동("61", "125", "127", "4", "8.47", "37", "29", "49.6", "127.06901944444444", "37.49711111111111"),
    대치4동("61", "125", "127", "3", "35.47", "37", "29", "49.07", "127.05985277777778", "37.49696388888889"),
    역삼1동("61", "125", "127", "2", "6.52", "37", "29", "33.3", "127.03514444444444", "37.492583333333336"),
    역삼2동("61", "125", "127", "2", "55.88", "37", "29", "35.69", "127.04885555555555", "37.49324722222222"),
    도곡1동("61", "125", "127", "2", "25.79", "37", "29", "17.04", "127.04049722222221", "37.48806666666667"),
    도곡2동("61", "125", "127", "2", "43.44", "37", "28", "47.51", "127.0454", "37.47986388888889"),
    개포1동("61", "125", "127", "3", "34.4", "37", "28", "44.75", "127.05955555555555", "37.47909722222222"),
    개포2동("62", "125", "127", "4", "32.67", "37", "29", "6.63", "127.07574166666666", "37.485175"),
    개포4동("61", "125", "127", "3", "13.44", "37", "28", "33.7", "127.05373333333333", "37.47602777777778"),
    세곡동("62", "125", "127", "6", "33.71", "37", "27", "58.92", "127.10936388888888", "37.46636666666667"),
    일원본동("62", "125", "127", "5", "18.96", "37", "28", "49.92", "127.0886", "37.480533333333334"),
    일원1동("62", "125", "127", "5", "24.47", "37", "29", "20.61", "127.09013055555555", "37.48905833333333"),
    일원2동("62", "125", "127", "4", "32.47", "37", "29", "21.64", "127.07568611111111", "37.48934444444445"),
    수서동("62", "125", "127", "6", "25.2", "37", "29", "9.7", "127.107", "37.48602777777778");


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

    GangnamGu(
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

    public String getName() {
        return name();
    }


}
