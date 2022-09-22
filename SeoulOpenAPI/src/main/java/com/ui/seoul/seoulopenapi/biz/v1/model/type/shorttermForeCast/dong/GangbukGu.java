package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum GangbukGu {

    강북구("61", "128", "127", "1", "39.79", "37", "38", "13.04", "127.02771944444444", "37.63695555555555"),
    삼양동("61", "128", "127", "1", "13.84", "37", "37", "28.14", "127.0205111111111", "37.62448333333333"),
    미아동("61", "128", "127", "1", "44.47", "37", "37", "26.89", "127.02901944444444", "37.62413611111111"),
    송중동("61", "128", "127", "2", "9.0", "37", "36", "48.1", "127.03583333333333", "37.61336111111111"),
    송천동("61", "128", "127", "1", "33.44", "37", "36", "55.86", "127.02595555555556", "37.61551666666667"),
    삼각산동("61", "128", "127", "1", "11.47", "37", "36", "51.95", "127.01985277777777", "37.61443055555556"),
    번1동("61", "128", "127", "1", "51.67", "37", "38", "6.57", "127.03101944444444", "37.63515833333333"),
    번2동("61", "128", "127", "2", "27.4", "37", "37", "45.79", "127.04094444444445", "37.62938611111111"),
    번3동("61", "128", "127", "2", "55.28", "37", "37", "23.14", "127.04868888888889", "37.62309444444445"),
    수유1동("60", "128", "127", "1", "9.47", "37", "37", "50.64", "127.01929722222222", "37.63073333333333"),
    수유2동("61", "128", "127", "1", "19.35", "37", "38", "30.77", "127.02204166666667", "37.64188055555555"),
    수유3동("61", "128", "127", "1", "31.15", "37", "38", "9.5", "127.02531944444445", "37.63597222222222"),
    우이동("60", "128", "127", "0", "50.64", "37", "38", "42.7", "127.01406666666666", "37.64519444444444"),
    인수동("60", "128", "127", "0", "45.96", "37", "38", "19.44", "127.01276666666666", "37.638733333333334");


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

    GangbukGu(
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
