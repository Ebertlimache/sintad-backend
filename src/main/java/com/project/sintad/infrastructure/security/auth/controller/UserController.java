package com.project.sintad.infrastructure.security.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sintad.infrastructure.security.auth.model.User;
import com.project.sintad.infrastructure.security.auth.service.UserService;
import com.project.sintad.infrastructure.security.auth.dto.UserResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();
        
        UserResponseDto userResponseDto = new UserResponseDto(currentUser);

        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> allUsers() {
        List<User> users = userService.allUsers();
        
        List<UserResponseDto> userResponseDtos = users.stream()
            .map(UserResponseDto::new)
            .collect(Collectors.toList());

        return ResponseEntity.ok(userResponseDtos);
    }
}