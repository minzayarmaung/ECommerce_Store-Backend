package com.project.storeSystem.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.SignatureException;
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

    public static boolean validToken(String token , String username){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String tokenUsername = claims.getSubject();
            Date expiration = claims.getExpiration();

            return (username.equals(tokenUsername) && !expiration.before(new Date()));

        } catch (Exception e) {
            return false;
        }
    }

}
