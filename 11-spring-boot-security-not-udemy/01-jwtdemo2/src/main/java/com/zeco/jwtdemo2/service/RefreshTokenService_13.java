package com.zeco.jwtdemo2.service;


import com.zeco.jwtdemo2.entity.RefreshToken_12;
import com.zeco.jwtdemo2.entity.Users_01;
import com.zeco.jwtdemo2.repository.RefreshTokenRepository_13;
import com.zeco.jwtdemo2.repository.UserRepository_04;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService_13 {

    private final RefreshTokenRepository_13 refreshTokenRepository;
    private final UserRepository_04 userRepository;

    public RefreshTokenService_13(RefreshTokenRepository_13 refreshTokenRepository, UserRepository_04 userRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
    }

    public RefreshToken_12 createRefreshToken(String username){
        Users_01 user = userRepository.findByUsername(username).orElseThrow();

        RefreshToken_12 refreshToken = new RefreshToken_12();
        refreshToken.setUser(user);
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExp_date(Instant.now().plusMillis(600000));// set expiry of refresh token to 10 minutes - you can configure it application.properties file

        return refreshTokenRepository.save(refreshToken);
    }

     public Optional<RefreshToken_12> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
     }

     public RefreshToken_12 verifyExpiration(RefreshToken_12 token){
        //positive value if exp_date is greter than the Instant time
         //negative if exp_date is less , meaning token is expired
         //equals to zero if both are equal


        if(token.getExp_date().compareTo(Instant.now()) < 0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + "refresh token is expired. Please make a new login");
        }

        return token;
     }
}
