package com.jws.wonseok.config.filter.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;

@Service
public class TokenDecoding {

    @Value("${security.jwt.token.secret-key}")
    private String jwt;

    public String getSubject(String token) {
        Claims claim = Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(jwt))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claim.getSubject();
    }
}
