package com.orbistech.kronoslog.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    @Value("${spring.security.jwt.secret}")
    private String secret;

    public String generateToken(String username, List<String> roles) {
        // Convertir los roles a mayúsculas y agregar el prefijo "ROLE_"
        List<String> prefixedRoles = roles.stream()
                .map(role -> "ROLE_" + role.toUpperCase())
                .collect(Collectors.toList());

        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", prefixedRoles);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String generateTokenWithExtendedExpiration(String username, List<String> roles) {
        // Convertir los roles a mayúsculas y agregar el prefijo "ROLE_"
        List<String> prefixedRoles = roles.stream()
                .map(role -> "ROLE_" + role.toUpperCase())
                .collect(Collectors.toList());

        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", prefixedRoles);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 604800000)) // 7 días
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Metodo para obtener los roles del token
    public List<String> extractRoles(String token) {
        return (List<String>) extractClaims(token).get("roles");
    }

    // Metodo para validar el token
    public boolean validateToken(String token) {
        try {
            Claims claims = extractClaims(token);
            return !isTokenExpired(token); // El token es válido si no ha expirado
        } catch (JwtException | IllegalArgumentException e) {
            // Maneja la excepción si el token no es válido
            return false;
        }
    }
}