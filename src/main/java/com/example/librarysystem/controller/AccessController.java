package com.example.librarysystem.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class AccessController {

    @GetMapping("/public")
    public String publicPage(@AuthenticationPrincipal UserDetails user) {
        if (user == null) {
            return "Du är inte inloggad. Besök /login för att logga in.";
        }
        String roles = user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(", "));
        return "Du är inloggad som " + user.getUsername() + " med roller: " + roles;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hej! Du är inloggad.";
    }

    @GetMapping("/user-page")
    public String userPage() {
        return "Användarsida: åtkomst för USER och ADMIN.";
    }

    @GetMapping("/admin-page")
    public String adminPage() {
        return "Adminsida: endast ADMIN.";
    }
}

