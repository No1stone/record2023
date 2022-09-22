package com.ui.seoul.seoulopenapi.biz.v1.model.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class RealTimeFineDustRes {
    private String MSRDATE;
    private int MSRADMCODE;
    private String MSRSTENAME;
    private String MAXINDEX;
    private String GRADE;
    private String POLLUTANT;
    private String NITROGEN;
    private String OZONE;
    private String CARBON;
    private String SULFUROUS;
    private String PM10;
    private String PM25;


}
