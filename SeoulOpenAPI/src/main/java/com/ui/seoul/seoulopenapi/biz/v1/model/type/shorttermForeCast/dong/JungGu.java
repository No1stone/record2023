package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum JungGu {
    중구("60","127","126","59","58.71","37","33","39.61","126.99964166666666","37.56100277777777"),
    소공동("60","127","126","58","44.79","37","33","34.67","126.97910833333333","37.55963055555555"),
    회현동("60","126","126","58","53.2","37","33","16.14","126.98144444444445","37.55448333333333"),
    명동("60","127","126","59","16.4","37","33","26.05","126.98788888888889","37.55723611111111"),
    필동("60","127","126","59","51.76","37","33","26.47","126.99771111111112","37.55735277777777"),
    장충동("60","127","127","0","35.76","37","33","32.82","127.00993333333334","37.55911666666666"),
    광희동("60","127","127","0","25.79","37","33","42.23","127.00716388888888","37.561730555555556"),
    을지로동("60","127","126","59","36.35","37","33","50.04","126.99343055555556","37.5639"),
    신당동("60","127","127","0","59.88","37","33","33.52","127.01663333333333","37.55931111111111"),
    다산동("60","126","127","0","37.11","37","33","5.82","127.01030833333333","37.55161666666666"),
    약수동("60","126","127","0","39.91","37","32","58.77","127.01108611111111","37.54965833333333"),
    청구동("60","126","127","1","0.44","37","33","15.33","127.01678888888888","37.55425833333333"),
    신당제5동("61","127","127","1","26.28","37","33","44.39","127.02396666666667","37.562330555555555"),
    동화동("61","127","127","1","17.55","37","33","26.02","127.02154166666666","37.557227777777776"),
    황학동("61","127","127","1","24.59","37","33","52.79","127.02349722222222","37.56466388888889"),
    중림동("60","126","126","57","59.76","37","33","7.32","126.9666","37.552033333333334");

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

    JungGu(
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
