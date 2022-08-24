package com.example.mybatisjpadslmulticonnect.db.second.repo;

import com.example.mybatisjpadslmulticonnect.db.second.entity.TbCmnCode;
import com.example.mybatisjpadslmulticonnect.db.second.entity.id.CmnCodeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TbCodeRepository2 extends JpaRepository<TbCmnCode, CmnCodeId> {
}
