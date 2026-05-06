package com.example.EmployeeJWTJPA.util;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private static final String SECRET = "your_secret_key_here";

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return "jwt_token_" + subject + "_" + System.currentTimeMillis();
    }

    public String extractUsername(String token) {
        // Simple extraction - in real app use proper JWT parsing
        if (token.startsWith("jwt_token_")) {
            String[] parts = token.split("_");
            if (parts.length >= 3) {
                return parts[2];
            }
        }
        return null;
    }

    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername != null && extractedUsername.equals(username));
    }
}
