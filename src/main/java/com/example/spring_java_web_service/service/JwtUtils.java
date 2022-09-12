package com.example.spring_java_web_service.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtils {

    private final int EXPIRATION_MILLS = 1000 * 60;
    private String secret="hemligt";

    public String generateToken(String username){
      return  Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION_MILLS))
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();//sätter ihop till en url säker kod
    }

    public Boolean validate(String token) {
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Claims parseBody(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}
