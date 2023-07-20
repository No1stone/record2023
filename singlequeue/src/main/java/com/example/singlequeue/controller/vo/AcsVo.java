package com.example.singlequeue.controller.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AcsVo {

    private int acsStatus;
    private int licenseCount;

    public AcsVo(int acsStatus, int licenseCount) {
        this.acsStatus = acsStatus;
        this.licenseCount = licenseCount;
    }
}
