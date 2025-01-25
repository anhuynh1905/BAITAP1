package com.ltdd.baitap241.repository;

import com.ltdd.baitap241.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
