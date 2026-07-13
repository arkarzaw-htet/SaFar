package com.arkar.hotel_booking.controller;

import com.arkar.hotel_booking.dto.auth.AuthResponse;
import com.arkar.hotel_booking.dto.auth.LoginRequest;
import com.arkar.hotel_booking.dto.auth.RegisterRequest;
import com.arkar.hotel_booking.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {

        return authService.login(request);
    }

}