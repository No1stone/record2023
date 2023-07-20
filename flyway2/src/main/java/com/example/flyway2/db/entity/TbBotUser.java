package com.example.flyway2.db.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Table(name = "TB_BOT_USER")
@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class TbBotUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SEQ", nullable = false)
    private Long userSeq;
    @Column(name = "CUST_CODE", nullable = false, length = 20)
    private String custCode;
    @Column(name = "LAST_USE_SERVICE_GROUP", nullable = false, length = 20)
    private String lastUseServiceGroup;
    @Column(name = "ROLE_VAL", nullable = false, length = 100)
    private String roleVal;
    @Column(name = "USER_ID", nullable = false, length = 20)
    private String userId;
    @Column(name = "PASSWORD", nullable = false, length = 200)
    private String password;
    @Column(name = "USER_NAME", nullable = false, length = 20)
    private String userName;
    @Column(name = "E_MAIL", nullable = true, length = 50)
    private String eMail;
    @Column(name = "MOBILE_NO", nullable = true, length = 15)
    private String mobileNo;
    @Column(name = "LOGIN_CHECK", nullable = false, length = 10)
    private int loginCheck;
    @Column(name = "USE_YN", nullable = false, length = 1)
    private String useYn;
    @Column(name = "REGIST_ID", nullable = false, length = 20)
    private String registId;
    @Column(name = "REGIST_DATE", nullable = false)
    private LocalDateTime registDate;
    @Column(name = "UPDATE_ID", nullable = true, length = 20)
    private String updateId;
    @Column(name = "UPDATE_DATE", nullable = true)
    private LocalDateTime updateDate;


    @Builder
    public TbBotUser(Long userSeq, String custCode, String lastUseServiceGroup, String roleVal, String userId, String password, String userName, String eMail, String mobileNo, int loginCheck, String useYn, String registId, LocalDateTime registDate, String updateId, LocalDateTime updateDate) {
        this.userSeq = userSeq;
        this.custCode = custCode;
        this.lastUseServiceGroup = lastUseServiceGroup;
        this.roleVal = roleVal;
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.eMail = eMail;
        this.mobileNo = mobileNo;
        this.loginCheck = loginCheck;
        this.useYn = useYn;
        this.registId = registId;
        this.registDate = registDate;
        this.updateId = updateId;
        this.updateDate = updateDate;
    }
}
