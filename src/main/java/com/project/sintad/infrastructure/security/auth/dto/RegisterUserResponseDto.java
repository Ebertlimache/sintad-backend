package com.project.sintad.infrastructure.security.auth.dto;

import com.project.sintad.infrastructure.security.auth.model.User;

public class RegisterUserResponseDto {
    private String username;
    private String email;
    private String fullName;

    public RegisterUserResponseDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.fullName = user.getFullName();
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
