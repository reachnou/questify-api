package edu.mui.cs489.reachnou.questify.util;

import edu.mui.cs489.reachnou.questify.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Slf4j
@Component
public class JwtTokenUtil {

    SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    @Value("${app.jwt.expire.duration}")
    private Long EXPIRE_DURATION;

    public String generateToken(User user){
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("ROLE", user.getRoles())
                .setIssuer("Questify")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        }catch (ExpiredJwtException e){
            log.error("Expired JWT : " + e.getMessage());
        }catch (MalformedJwtException e){
            log.error("Invalid JWT : " + e.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return false;
    }

    public Claims parseClaims(String token){
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
    }
}
