package com.zeco.jwtdemo2.service;


import com.zeco.jwtdemo2.entity.Users_01;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService_03 {

    //you can generate a key from :https://asecuritysite.com/encryption/plain, chose 256bit and click "determine
    private final String SECRET_KEY = "4d8ac202104f2b230b2ebaa5f3442808fbae0a35376e280f16e146acc69b9025";

    private SecretKey getSignedKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSignedKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }


    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public boolean isValid(String token, UserDetails user) {
        String username = extractUsername(token);

        /**boolean validToken = tokenRepository
                .findByToken(token)
                .map(t -> !t.isLoggedOut())
                .orElse(false);**/

        return (username.equals(user.getUsername())) && !isTokenExpired(token) /*&& validToken*/;
    }

    public String generateToken(String userName) {
        String token = Jwts
                .builder()
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 24*60*60*1000 ))//expire after 24hrs
                .signWith(getSignedKey())
                .compact();

        return token;
    }



}
