package com.cardenascode.gestion_candidatos.infrastructure.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {


    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration-ms}")
    private long expirationMs;

    public String generateToken(String email) {
        SecretKey key = getSigningKey(secret);
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key)
                .compact();
    }

    SecretKey getSigningKey(String jwtSecret) {
        return KeyHelper.getSigningKey(jwtSecret);
    }
}
