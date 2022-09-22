package com.jws.wonseok.biz.v1.EnumTestModel;


import com.jws.wonseok.jpa.entity.MediaVerify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MediaVerifyReq {

    private Long accntId;
    private String mediaVerifyReqId;
    private String mediaValidString;

    public MediaVerify MediaVerifyReq(){

        return MediaVerify
                .builder()
                .accntId(this.accntId)
                .mediaVerifyReqId(this.mediaVerifyReqId)
                .mediaValidString(this.mediaValidString)
                .mediaTypeCd("TestType")
                .verifyTypeCd("TestType")
                .expiredDt(LocalDateTime.now())
                .regDt(LocalDateTime.now())
                .build();
    }


}
