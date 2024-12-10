package com.project.sintad.infrastructure.security.auth.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.sintad.infrastructure.security.auth.dto.LoginUserDto;
import com.project.sintad.infrastructure.security.auth.dto.RegisterUserDto;
import com.project.sintad.infrastructure.security.auth.model.User;
import com.project.sintad.infrastructure.security.auth.repository.UserRepository;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthenticationService authenticationService;

    public AuthenticationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSignup() {
        RegisterUserDto registerUserDto = new RegisterUserDto("Jane Smith", "jane@example.com", "newpassword");
        User user = new User("Jane Smith", "jane@example.com", "newEncodedPassword");

        when(passwordEncoder.encode(registerUserDto.getPassword())).thenReturn("newEncodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = authenticationService.signup(registerUserDto);

        assertEquals("Jane Smith", result.getFullName());
        assertEquals("jane@example.com", result.getEmail());
        assertEquals("newEncodedPassword", result.getPassword());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testAuthenticate() {
        LoginUserDto loginUserDto = new LoginUserDto("jane@example.com", "newpassword");
        User user = new User("Jane Smith", "jane@example.com", "newEncodedPassword");
        Authentication authentication = mock(Authentication.class);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(userRepository.findByEmail(loginUserDto.getEmail())).thenReturn(Optional.of(user));

        User result = authenticationService.authenticate(loginUserDto);

        assertEquals("Jane Smith", result.getFullName());
        assertEquals("jane@example.com", result.getEmail());
        assertEquals("newEncodedPassword", result.getPassword());
        verify(authenticationManager, times(1)).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(userRepository, times(1)).findByEmail(loginUserDto.getEmail());
    }
}
