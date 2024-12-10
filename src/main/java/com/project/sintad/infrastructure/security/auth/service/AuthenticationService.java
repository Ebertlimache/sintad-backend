package com.project.sintad.infrastructure.security.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.sintad.infrastructure.security.auth.dto.LoginUserDto;
import com.project.sintad.infrastructure.security.auth.dto.RegisterUserDto;
import com.project.sintad.infrastructure.security.auth.model.User;
import com.project.sintad.infrastructure.security.auth.repository.UserRepository;

@Service
public class AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        logger.info("Registering user with email: {}", input.getEmail());
        User user = new User(input.getFullName(), input.getEmail(), passwordEncoder.encode(input.getPassword()));
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            logger.error("Error registering user: {}", e.getMessage());
            throw new RuntimeException("Error registering user", e);
        }
    }

    public User authenticate(LoginUserDto input) {
        logger.info("Authenticating user with email: {}", input.getEmail());
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    input.getEmail(),
                    input.getPassword()
                )
            );
            return userRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        } catch (Exception e) {
            logger.error("Authentication failed for user: {}", input.getEmail());
            throw new RuntimeException("Authentication failed", e);
        }
    }
}