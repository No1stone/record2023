package com.jws.wonseok.jpa.entity;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_media_verify")
@DynamicUpdate
public class MediaVerify {

    @Id
    @Column(name = "accnt_id")
    private Long accntId;
    @Column(name = "media_verify_req_id", nullable = true, length = 36)
    private String mediaVerifyReqId;
    @Column(name = "media_type_cd", nullable = true, length = 9)
    private String mediaTypeCd;
    @Column(name = "media_valid_string", nullable = true, length = 20)
    private String mediaValidString;
    @Column(name = "verify_type_cd", nullable = true, length = 9)
    private String verifyTypeCd;
    @Column(name = "expired_dt", nullable = true)
    private LocalDateTime expiredDt;
    @Column(name = "reg_dt", nullable = true)
    private LocalDateTime regDt;

    @Builder
    MediaVerify(
            Long accntId,
            String mediaVerifyReqId,
            String mediaTypeCd,
            String mediaValidString,
            String verifyTypeCd,
            LocalDateTime expiredDt,
            LocalDateTime regDt
    ) {
        this.accntId = accntId;
        this.mediaVerifyReqId = mediaVerifyReqId;
        this.mediaTypeCd = mediaTypeCd;
        this.mediaValidString = mediaValidString;
        this.verifyTypeCd = verifyTypeCd;
        this.expiredDt = expiredDt;
        this.regDt = regDt;
    }
}
