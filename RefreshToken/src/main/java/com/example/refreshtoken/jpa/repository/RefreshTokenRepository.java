package com.example.refreshtoken.jpa.repository;

import com.example.refreshtoken.jpa.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

    Optional<RefreshToken> findByKey(String key);

}
