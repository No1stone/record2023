package com.jws.wonseok.jpa.repository;

import com.jws.wonseok.jpa.entity.MediaVerify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaVerifyRepository extends JpaRepository<MediaVerify, Long> {
    boolean existsByAccntIdAndMediaValidString(Long id, String key);
}
