package com.project.storeSystem.Util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtil {

    private static final String SECRET_KEY = "a3Gq9gFwktvLJZdQN8zVpFVHQFfZsVslF3jV9EsZLZ8=";

    public static String generateToken(String username) {
        long expiredTime = 24 * 60 * 60 * 1000;

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiredTime))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

}
