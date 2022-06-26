package com.Prograd.Springboot.Backend.Security.Jwt;

import com.Prograd.Springboot.Backend.Modals.Student;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import java.util.*;

@Component
public class JwtTokenHelper {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenHelper.class);
    public static final long JWT_TOKEN_VALIDITY = 180000;

    private String jwtSecret = "jwttokenkey";

    public String generateJwtToken(Authentication authentication) {

        Student userPrincipal = (Student) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getEmail()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        System.out.println(Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject());
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
