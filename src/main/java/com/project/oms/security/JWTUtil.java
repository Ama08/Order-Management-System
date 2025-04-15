package com.project.oms.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private final String jwtSecret = "secret-key";
    private final long jwtExpirationMs = 86400000;

    public String generateToken(String username){
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.ES512, jwtSecret)
                .compact();
    }

    public String extactUsername(String token){
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validationToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
