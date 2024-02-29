package com.zeco.jwtdemo2.repository;

import com.zeco.jwtdemo2.entity.RefreshToken_12;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface RefreshTokenRepository_13 extends JpaRepository<RefreshToken_12,Integer> {
    Optional<RefreshToken_12> findByToken(String token);
}
