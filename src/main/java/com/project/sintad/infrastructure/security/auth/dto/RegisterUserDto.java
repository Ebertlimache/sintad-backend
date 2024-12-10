package com.project.sintad.infrastructure.security.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterUserDto {
    
    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no es válido")
    @Size(max = 100, message = "El correo electrónico debe tener como máximo 100 caracteres")  
    private String email;
    
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, max = 100, message = "La contraseña debe tener entre 6 y 100 caracteres")  
    private String password;
    
    @NotBlank(message = "El nombre completo es obligatorio")
    @Size(max = 100, message = "El nombre completo no puede exceder los 100 caracteres")
    private String fullName;

    public RegisterUserDto(
            @NotBlank(message = "El correo electrónico es obligatorio") @Email(message = "El correo electrónico no es válido") @Size(max = 100, message = "El correo electrónico debe tener como máximo 100 caracteres") String email,
            @NotBlank(message = "La contraseña es obligatoria") @Size(min = 6, max = 100, message = "La contraseña debe tener entre 6 y 100 caracteres") String password,
            @NotBlank(message = "El nombre completo es obligatorio") @Size(max = 100, message = "El nombre completo no puede exceder los 100 caracteres") String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
}