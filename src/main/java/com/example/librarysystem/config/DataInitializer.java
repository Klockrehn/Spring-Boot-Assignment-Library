//Kryptera redan existerande lösenord
package com.example.librarysystem.config;

import com.example.librarysystem.entity.User;
import com.example.librarysystem.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Component
public class DataInitializer implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("DataInitializer körs...");

        for (User u : userRepository.findAll()) {
            String pwd = u.getPassword();
            if (pwd == null) continue;
            if (!(pwd.startsWith("$2a$") || pwd.startsWith("$2b$") || pwd.startsWith("$2y$"))) {
                u.setPassword(passwordEncoder.encode(pwd));
                userRepository.save(u);
                System.out.println("Migrerade lösenord för: " + u.getEmail());
            }
        }
    }
}