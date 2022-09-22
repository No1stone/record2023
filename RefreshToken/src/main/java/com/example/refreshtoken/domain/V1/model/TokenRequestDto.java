package com.example.refreshtoken.domain.V1.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRequestDto {
    private String accessToken;
    private String refreshToken;
}
