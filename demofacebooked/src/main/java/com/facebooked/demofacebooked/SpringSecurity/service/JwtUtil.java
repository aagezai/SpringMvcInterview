package com.facebooked.demofacebooked.SpringSecurity.service;

import com.facebooked.demofacebooked.SpringSecurity.model.UserAuth;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class JwtUtil {


    private final String secret_key = "KwfGfZ+FQxhz6XLIp3mAsHbeI3B3F1Qe7ONXTmxM31Q=";
    private static final byte[] SECRET_KEY_BYTES = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();

    private long accessTokenValidity = 60*60*1000;

    private final JwtParser jwtParser;

    private final String TOKEN_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";

    public JwtUtil(){

        this.jwtParser = Jwts.parser().setSigningKey(secret_key);
    }

    public String createToken(UserAuth user) {
        System.out.println("in createToken");

        Claims claims = Jwts.claims().setSubject(user.getEmail());
        claims.put("firstName",user.getFirstName());
        claims.put("lastName",user.getLastName());
        Date tokenCreateTime = new Date();
        Date tokenValidity = new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(tokenValidity)
                .signWith(SignatureAlgorithm.HS256, secret_key)
                .compact();
    }

    private Claims parseJwtClaims(String token) {

        return jwtParser.setSigningKey(secret_key).parseClaimsJws(token).getBody();
    }

    public Claims resolveClaims(HttpServletRequest req) {
        try {
            String token = resolveToken(req);
            if (token != null) {
                return parseJwtClaims(token);
            }
            return null;
        } catch (ExpiredJwtException ex) {
            req.setAttribute("expired", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            req.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    }

    public String resolveToken(HttpServletRequest request) {
        System.out.println("in resolveToken");
        String bearerToken = request.getHeader(TOKEN_HEADER);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            throw e;
        }
    }

    public String getEmail(Claims claims) {
        return claims.getSubject();
    }

    private List<String> getRoles(Claims claims) {
        return (List<String>) claims.get("roles");
    }

    public static void main(String[] args) {
       // String jwt_token =new JwtUtil().createToken(new UserAuth("testEmailtestEmailtestEmail","testPasswordtestPasswordtestPassword"));
       // System.out.println(jwt_token);
        //String randomSecretKey = generateRandomSecretKey();
        //System.out.println("Random Secret Key: " + randomSecretKey);
    }
    private static String generateRandomSecretKey() {
        byte[] keyBytes = new byte[32]; // Adjust the size as needed
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(keyBytes);
        return Base64.getEncoder().encodeToString(keyBytes);
    }


}