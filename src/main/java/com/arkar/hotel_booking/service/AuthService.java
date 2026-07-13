package com.arkar.hotel_booking.service;

import com.arkar.hotel_booking.dto.auth.AuthResponse;
import com.arkar.hotel_booking.dto.auth.LoginRequest;
import com.arkar.hotel_booking.dto.auth.RegisterRequest;
import com.arkar.hotel_booking.entity.User;
import com.arkar.hotel_booking.entity.UserRole;
import com.arkar.hotel_booking.exception.EmailAlreadyExistsException;
import com.arkar.hotel_booking.repository.UserRepository;
import com.arkar.hotel_booking.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists.");
        }

        // Determine role: default to GUEST unless specified
        UserRole role =  UserRole.GUEST;

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setCountry(request.getCountry());
        user.setRole(role);
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        return AuthResponse.builder()
                .message("User registered successfully.")
                .userId(savedUser.getId())
                .email(savedUser.getEmail())
                .role(savedUser.getRole().toString())
                .build();
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password.");
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(user);

        return AuthResponse.builder()
                .message("Login successful.")
                .token(token)
                .userId(user.getId())
                .email(user.getEmail())
                .role(user.getRole().toString())
                .build();
    }
}