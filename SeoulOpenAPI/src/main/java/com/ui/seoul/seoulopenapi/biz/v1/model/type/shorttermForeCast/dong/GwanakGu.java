package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong;

public enum GwanakGu {
    관악구("59","125","126","57","13.84","37","28","31.39","126.95384444444444","37.47538611111111"),
    보라매동("59","125","126","56","5.59","37","29","7.1","126.93488611111111","37.485305555555556"),
    청림동("59","125","126","57","38.4","37","29","20.54","126.96066666666667","37.48903888888889"),
    성현동("59","125","0","0","0.0","0","0","0.0","126.9481357","37.4896244"),
    행운동("59","125","126","57","32.52","37","28","40.38","126.95903333333334","37.47788333333334"),
    낙성대동("60","125","126","57","37.76","37","28","24.6","126.96048888888889","37.4735"),
    청룡동("59","125","0","0","0.0","0","0","0.0","126.94155","37.479151"),
    은천동("59","125","0","0","0.0","0","0","0.0","126.9424278","37.4853086"),
    중앙동("59","125","126","57","6.32","37","28","53.19","126.95175555555556","37.48144166666667"),
    인헌동("59","125","126","58","2.55","37","28","20.3","126.967375","37.47230555555556"),
    남현동("60","125","126","58","47.84","37","28","18.44","126.97995555555556","37.47178888888889"),
    서원동("59","125","0","0","0.0","0","0","0.0","126.9313","37.4797346"),
    신원동("59","125","126","55","45.91","37","28","43.6","126.92941944444445","37.47877777777778"),
    서림동("59","125","126","56","13.4","37","28","19.79","126.93705555555556","37.47216388888889"),
    신사동("59","125","0","0","0.0","0","0","0.0","126.9180796","37.4854118"),
    신림동("59","125","0","0","0.0","0","0","0.0","126.927075","37.487426"),
    난향동("59","124","0","0","0.0","0","0","0.0","126.918842","37.461429"),
    조원동("59","125","0","0","0.0","0","0","0.0","126.9078649","37.4826299"),
    대학동("59","125","0","0","0.0","0","0","0.0","126.9369907","37.4706145"),
    삼성동("59","125","0","0","0.0","0","0","0.0","126.932963","37.470101"),
    미성동("59","125","0","0","0.0","0","0","0.0","126.9155534","37.4761761"),
    난곡동("59","125","0","0","0.0","0","0","0.0","126.9216507","37.4709634");



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

    GwanakGu(
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
