package com.example.flyway2.db.repo;

import com.example.flyway2.db.entity.TbBotUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TbBotUserRepo extends JpaRepository<TbBotUser, Long> {

    Optional<TbBotUser> findByUserId(String userId);
    Optional<TbBotUser> findByUserSeq(Long userSeq);
    boolean existsByUserId(String userId);
    Optional<TbBotUser> findByUserIdAndUseYn(String userId, String useYn);
    Optional<TbBotUser> findByUserIdAndPasswordAndUseYn(String userId, String pass, String useYn);
    boolean existsByUserIdAndPasswordAndUseYn(String userId, String pass, String useYn);
    Optional<TbBotUser> findByUserSeqAndUseYn(Long seq, String use);

    List<TbBotUser> findByCustCodeAndUseYn(String custCode, String yn);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE TB_BOT_USER " +
                    "SET LOGIN_CHECK = LOGIN_CHECK + 1 " +
                    "WHERE USER_ID = :userId "
//                    "AND SOLUTION_CODE = 'VM'"
            , nativeQuery = true
    )
    int loginFail(@Param("userId") String userId);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE TB_BOT_USER " +
                    "SET USE_Yn = :useYn " +
                    "WHERE USER_ID = :userId "
//                    "AND SOLUTION_CODE = 'VM'"
            , nativeQuery = true
    )
    void jpqlUesYn(@Param("userId") String userId, @Param("useYn") String useYn);
}
