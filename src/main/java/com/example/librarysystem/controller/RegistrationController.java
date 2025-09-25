package com.example.librarysystem.controller;

import com.example.librarysystem.dto.RegistrationRequest;
import com.example.librarysystem.entity.User;
import com.example.librarysystem.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private static final Pattern PW_PATTERN = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d).{8,}$");

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest req) {

        Optional<User> existing = userRepository.findByEmailIgnoreCase(req.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity.status(409).body("E-post är redan registrerad.");
        }

        if (!PW_PATTERN.matcher(req.getPassword()).matches()) {
            return ResponseEntity.badRequest().body("Lösenord måste vara minst 8 tecken och innehålla både bokstäver och siffror.");
        }

        User u = new User();
        u.setFirstName(req.getFirstName());
        u.setLastName(req.getLastName());
        u.setEmail(req.getEmail());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u.setRegistrationDate(LocalDate.now());
        u.setRole("USER");
        u.setEnabled(1);

        userRepository.save(u);
        return ResponseEntity.ok("Användare registrerad.");
    }
}

