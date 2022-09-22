package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum DongdaemunGu {
    동대문구("61", "127", "127", "2", "31.71", "37", "34", "17.85", "127.04214166666667", "37.571625000000004"),
    용신동("61", "127", "0", "0", "0.0", "0", "0", "0.0", "127.0372169", "37.5758185"),
    제기동("61", "127", "0", "0", "0.0", "0", "0", "0.0", "127.0377843", "37.5830767"),
    전농제1동("61", "127", "127", "2", "59.52", "37", "34", "30.76", "127.04986666666666", "37.575211111111116"),
    전농제2동("61", "127", "127", "3", "13.91", "37", "34", "54.13", "127.05386388888888", "37.58170277777778"),
    답십리제1동("61", "127", "127", "3", "15.2", "37", "34", "9.39", "127.05422222222222", "37.569275000000005"),
    답십리제2동("61", "127", "127", "3", "41.67", "37", "34", "8.95", "127.06157499999999", "37.56915277777778"),
    장안제1동("61", "127", "127", "4", "6.52", "37", "33", "53.95", "127.06847777777777", "37.56498611111111"),
    장안제2동("61", "127", "127", "4", "31.11", "37", "34", "6.27", "127.07530833333333", "37.56840833333334"),
    청량리동("61", "127", "0", "0", "0.0", "0", "0", "0.0", "127.0472767", "37.5862586"),
    회기동("61", "127", "127", "3", "26.96", "37", "35", "16.83", "127.05748888888888", "37.588008333333335"),
    휘경제1동("61", "127", "127", "4", "4.15", "37", "35", "24.57", "127.06781944444444", "37.590158333333335"),
    휘경제2동("61", "127", "127", "4", "10.76", "37", "35", "18.58", "127.06965555555556", "37.58849444444445"),
    이문제1동("61", "127", "127", "4", "3.47", "37", "35", "42.0", "127.06763055555555", "37.595"),
    이문제2동("61", "127", "127", "3", "31.03", "37", "35", "30.23", "127.05861944444445", "37.59173055555556");

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

    DongdaemunGu(
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
