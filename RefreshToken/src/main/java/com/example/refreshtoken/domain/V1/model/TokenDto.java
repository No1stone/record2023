package com.example.refreshtoken.domain.V1.model;

import lombok.*;

@Getter@Setter@Builder
@NoArgsConstructor@AllArgsConstructor
public class TokenDto {
    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiresIn;
}
