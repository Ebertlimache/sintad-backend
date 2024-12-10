package com.project.sintad.infrastructure.security.auth.dto;

import com.project.sintad.infrastructure.security.auth.model.User;

public class UserResponseDto {
    private String username;
    private String email;

    public UserResponseDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
