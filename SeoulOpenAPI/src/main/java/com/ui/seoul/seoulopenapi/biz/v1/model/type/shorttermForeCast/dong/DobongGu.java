package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum DobongGu {

    도봉구("61", "129", "127", "2", "58.28", "37", "39", "57.0", "127.04952222222222", "37.66583333333333"),
    창제1동("61", "128", "127", "2", "45.59", "37", "38", "44.33", "127.04599722222223", "37.64564722222222"),
    창제2동("61", "128", "127", "2", "15.96", "37", "38", "19.42", "127.03776666666667", "37.638727777777774"),
    창제3동("61", "128", "127", "2", "42.03", "37", "38", "6.97", "127.04500833333333", "37.63526944444445"),
    창제4동("61", "129", "127", "3", "13.2", "37", "38", "57.83", "127.05366666666666", "37.64939722222222"),
    창제5동("61", "129", "127", "2", "28.67", "37", "38", "57.17", "127.04129722222223", "37.64921388888889"),
    도봉제1동("61", "129", "127", "2", "43.84", "37", "40", "32.95", "127.04551111111111", "37.67581944444444"),
    도봉제2동("61", "129", "127", "2", "55.35", "37", "40", "1.2", "127.04870833333334", "37.666999999999994"),
    쌍문제1동("61", "128", "127", "1", "41.44", "37", "38", "42.89", "127.02817777777777", "37.645247222222224"),
    쌍문제2동("61", "129", "127", "2", "27.28", "37", "39", "18.29", "127.04091111111111", "37.65508055555556"),
    쌍문제3동("61", "128", "127", "1", "48.32", "37", "38", "46.3", "127.03008888888888", "37.64619444444445"),
    쌍문제4동("61", "129", "127", "1", "49.96", "37", "39", "13.05", "127.03054444444444", "37.653625"),
    방학제1동("61", "129", "127", "2", "33.96", "37", "39", "41.16", "127.04276666666667", "37.661433333333335"),
    방학제2동("61", "129", "127", "2", "14.0", "37", "39", "55.57", "127.03722222222223", "37.66543611111111"),
    방학제3동("61", "129", "127", "1", "48.28", "37", "39", "22.42", "127.03007777777778", "37.65622777777778");

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

    DobongGu(
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
