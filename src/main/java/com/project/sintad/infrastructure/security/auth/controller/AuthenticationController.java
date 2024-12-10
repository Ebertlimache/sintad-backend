package com.project.sintad.infrastructure.security.auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sintad.infrastructure.security.auth.dto.LoginUserDto;
import com.project.sintad.infrastructure.security.auth.dto.RegisterUserDto;
import com.project.sintad.infrastructure.security.auth.dto.RegisterUserResponseDto;
import com.project.sintad.infrastructure.security.auth.dto.LoginResponseDto;
import com.project.sintad.infrastructure.security.auth.model.LoginResponse;
import com.project.sintad.infrastructure.security.auth.model.User;
import com.project.sintad.infrastructure.security.auth.service.AuthenticationService;
import com.project.sintad.infrastructure.security.jwt.JwtService;

import jakarta.validation.Valid;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDto registerUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        User registeredUser = authenticationService.signup(registerUserDto);

        RegisterUserResponseDto responseDto = new RegisterUserResponseDto(registeredUser);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginUserDto loginUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        LoginResponseDto responseDto = new LoginResponseDto(jwtToken, jwtService.getExpirationTime());
        return ResponseEntity.ok(responseDto);
    }
}