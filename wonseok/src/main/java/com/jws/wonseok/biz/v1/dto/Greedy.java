package com.jws.wonseok.biz.v1.dto;

import lombok.*;

@Getter@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Greedy {
    int n;
    int[] lost;
    int[] reserve;

}
