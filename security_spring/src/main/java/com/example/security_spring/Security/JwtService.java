package com.example.security_spring.Security;

//import com.example.Spring.security.entity.User;
import com.example.security_spring.Entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

//    secret key of part in token
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

//    yk secret key tv hash text hx get secret key ban
    private SecretKey getSignInKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(User user) {
        return Jwts.builder()

//                subject brer for get email or number phone
                .subject(user.getEmail())

//                claim ng yg trv tea claim ler role lhot
                .claim("role", user.getRole())

//                create when
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))

//                get secret key
                .signWith(getSignInKey())
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public Date extractExpiration(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        return extractEmail(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}
