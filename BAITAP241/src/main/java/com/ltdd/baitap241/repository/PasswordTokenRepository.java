package com.ltdd.baitap241.repository;

import com.ltdd.baitap241.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    boolean existsByToken(String token);
    PasswordResetToken findByToken(String token);

    List<PasswordResetToken> token(String token);
}
