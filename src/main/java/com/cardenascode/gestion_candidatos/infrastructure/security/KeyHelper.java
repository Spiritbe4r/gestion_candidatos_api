package com.cardenascode.gestion_candidatos.infrastructure.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;

@Slf4j
public class KeyHelper {

    public KeyHelper() {}

    static SecretKey getSigningKey(String jwtSecret) {

        var key =Jwts.SIG.HS256.key().build();
        log.info("JWT secret key: {}", key.toString());

        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
