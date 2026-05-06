package com.example.EmployeeJWTJPA.controller;
import com.example.EmployeeJWTJPA.model.AppUser;
import com.example.EmployeeJWTJPA.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AppUser user) {
        if ("admin".equals(user.getUsername()) && "1234".equals(user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        throw new RuntimeException("Invalid credentials");
    }
}