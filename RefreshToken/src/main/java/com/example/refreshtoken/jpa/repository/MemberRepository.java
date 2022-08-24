package com.example.refreshtoken.jpa.repository;

import com.example.refreshtoken.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByMemberEmail(String email);
    Optional<Member> findByMemberEmail(String email);

}
