package com.arkar.hotel_booking.controller;

import com.arkar.hotel_booking.dto.user.UserCreateRequest;
import com.arkar.hotel_booking.dto.user.UserLoginRequest;
import com.arkar.hotel_booking.dto.user.UserResponse;
import com.arkar.hotel_booking.entity.User;
import com.arkar.hotel_booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserCreateRequest user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
