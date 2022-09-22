package com.example.refreshtoken.jpa.entity;

import com.example.refreshtoken.jpa.jpaenum.Authority;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "jws_member")
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(generator = "jws_member_seq")
    private Long memberId;
    @Column(name = "member_email")
    private String memberEmail;
    @Column(name = "member_password")
    private String memberPassword;
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String memberEmail, String memberPassword, Authority authority) {
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.authority = authority;
    }



}
