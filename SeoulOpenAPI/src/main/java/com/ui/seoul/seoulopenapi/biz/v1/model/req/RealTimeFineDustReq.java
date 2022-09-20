package com.ui.seoul.seoulopenapi.biz.v1.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class RealTimeFineDustReq {
    String MSRDATE;
    int MSRADMCODE;
    String MSRSTENAME;
    String MAXINDEX;
    String GRADE;
    String POLLUTANT;
    String NITROGEN;
    String OZONE;
    String CARBON;
    String SULFUROUS;
    String PM10;
    String PM25;


}
