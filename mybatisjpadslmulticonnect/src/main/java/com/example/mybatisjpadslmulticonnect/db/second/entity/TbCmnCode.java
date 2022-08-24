package com.example.mybatisjpadslmulticonnect.db.second.entity;

import com.example.mybatisjpadslmulticonnect.db.first.entity.id.CmnCodeId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "tb_cmn_code")
@IdClass(CmnCodeId.class)
@Entity
@Getter
@Setter
@NoArgsConstructor
public class TbCmnCode {

    @Id
    @Column(name = "id", nullable = true)
    private Long id;
    @Column(name = "ordr", nullable = true)
    private int ordr;
    @Column(name = "grp_cd", nullable = true)
    private String grpCd;
    @Id
    @Column(name = "cd", nullable = true)
    private String cd;
    @Column(name = "cd_val", nullable = true)
    private String cdVal;
    @Column(name = "cd_nm", nullable = true)
    private String cdNm;
    @Column(name = "use_yn", nullable = true)
    private String useYn;
    @Column(name = "reg_id", nullable = true)
    private Long regId;
    @Column(name = "reg_dt", nullable = true)
    private LocalDateTime regDt;
    @Column(name = "mod_id", nullable = true)
    private Long modId;
    @Column(name = "mod_dt", nullable = true)
    private LocalDateTime modDt;


    @Builder
    public TbCmnCode(Long id, int ordr, String grpCd, String cd, String cdVal, String cdNm, String useYn, Long regId, LocalDateTime regDt, Long modId, LocalDateTime modDt) {
        this.id = id;
        this.ordr = ordr;
        this.grpCd = grpCd;
        this.cd = cd;
        this.cdVal = cdVal;
        this.cdNm = cdNm;
        this.useYn = useYn;
        this.regId = regId;
        this.regDt = regDt;
        this.modId = modId;
        this.modDt = modDt;
    }


}
