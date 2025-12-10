package com.devfabiosimones.imageliteapi.application.jwt;

import com.devfabiosimones.imageliteapi.domain.AccessToken;
import com.devfabiosimones.imageliteapi.domain.entity.User;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class JwtService {

    private final SecretKeyGenerator secretKeyGenerator;

    public AccessToken generatedToken(User user) {
        SecretKey key = secretKeyGenerator.getKey();
        Date expirationDate = generateExpirationDate();
        var claims = generateTokenClaims(user);

        String token = Jwts
                .builder()
                .signWith(key)
                .subject(user.getEmail())
                .expiration(expirationDate)
                .claims(claims)
                .compact();
        return new AccessToken(token);
    }

    private Date generateExpirationDate() {
        var expirationMinutes = 60;
        LocalDateTime now = LocalDateTime.now().plusMinutes(expirationMinutes);
        return Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
    }

    private Map<String, Object> generateTokenClaims(User user){
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", user.getName());
        return claims;
    }

    public String getEmailFromToken(String tokenJwt){
        try{
            return Jwts.parser()
                    .verifyWith(secretKeyGenerator.getKey())
                    .build()
                    .parseSignedClaims(tokenJwt)
                    .getPayload()
                    .getSubject();
        }
        catch (JwtException e){
            throw new InvalidTokenException(e.getMessage());
        }

    }
}
