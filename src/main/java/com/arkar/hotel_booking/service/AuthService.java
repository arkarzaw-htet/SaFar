package com.arkar.hotel_booking.service;

import com.arkar.hotel_booking.dto.auth.AuthResponse;
import com.arkar.hotel_booking.dto.auth.LoginRequest;
import com.arkar.hotel_booking.dto.auth.RegisterRequest;
import com.arkar.hotel_booking.entity.User;
import com.arkar.hotel_booking.exception.EmailAlreadyExistsException;
import com.arkar.hotel_booking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists.");
        }

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setCountry(request.getCountry());
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return new AuthResponse("User registered successfully.");
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password.");
        }

        // JWT will be generated here later

        return new AuthResponse("Login successful.");
    }

}