package ua.com.alevel.config.security.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.security.JwtService;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${api.secret.key}")
    private String apiSecretKey;

    @Value("${api.secret.token.expiration}")
    private long apiSecretTokenExpiration;

    @Override
    public String generateToken(UserDetails userDetails) {
        return buildToken(new HashMap<>(), userDetails, apiSecretTokenExpiration);
    }

    @Override
    public <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = extract(token);
        return claimsTFunction.apply(claims);
    }

    @Override
    public boolean isTokenExpired(String token) {
        Date expiration = this.extractClaims(token, Claims::getExpiration);
        return expiration.before(new Date());
    }

    private String buildToken(Map<String, Object> claims, UserDetails userDetails, long expiration) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(apiSecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extract(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
