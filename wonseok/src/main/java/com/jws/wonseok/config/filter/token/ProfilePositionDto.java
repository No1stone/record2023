package com.jws.wonseok.config.filter.token;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfilePositionDto {

    private String companyCd;
    private Long profileId;
    private String anrYn;
    private String artistYn;
    private String deptRoleInfo;
    private Long positionSeq;

}
