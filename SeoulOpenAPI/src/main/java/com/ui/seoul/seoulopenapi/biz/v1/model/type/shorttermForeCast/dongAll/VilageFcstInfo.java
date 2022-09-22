package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dongAll;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VilageFcstInfo {

    private String baseDate;
    private String baseTime;
    private String category;
    private String fcstDate;
    private String fcstTime;
    private String fcstValue;
    private String nx;
    private String ny;

}
