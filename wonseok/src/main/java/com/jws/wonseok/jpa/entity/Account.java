package com.jws.wonseok.jpa.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_account")
public class Account {

    @Id
    private Long accountId;
    private Long accountRepositoryId;
    private String accountTypeCd;
    private LocalDateTime firstDt;

    @Builder
    Account(
            Long accountId,
            Long accountRepositoryId,
            String accountTypeCd,
            LocalDateTime firstDt
    ) {
        this.accountId = accountId;
        this.accountRepositoryId  = accountRepositoryId;
        this.accountTypeCd = accountTypeCd;
        this.firstDt = firstDt;
    }
}
