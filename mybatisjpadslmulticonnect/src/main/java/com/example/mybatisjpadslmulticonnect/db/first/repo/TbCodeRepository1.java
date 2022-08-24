package com.example.mybatisjpadslmulticonnect.db.first.repo;

import com.example.mybatisjpadslmulticonnect.db.first.entity.TbCmnCode;
import com.example.mybatisjpadslmulticonnect.db.first.entity.id.CmnCodeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TbCodeRepository1 extends JpaRepository<TbCmnCode, CmnCodeId> {
}
