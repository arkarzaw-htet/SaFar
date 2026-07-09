package com.arkar.hotel_booking.service;

import com.arkar.hotel_booking.dto.user.UserCreateRequest;
import com.arkar.hotel_booking.dto.user.UserResponse;
import com.arkar.hotel_booking.dto.user.UserSummaryResponse;
import com.arkar.hotel_booking.entity.User;
import com.arkar.hotel_booking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(UserCreateRequest request) {

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setCountry(request.getCountry());

        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail(),
                savedUser.getPhoneNumber(),
                savedUser.getCountry(),
                savedUser.getCreatedAt()
        );
    }
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPhoneNumber(),
                        user.getCountry(),
                        user.getCreatedAt()
                ))
                .toList();
    }
    public UserResponse getUser(Long id) {
        User savedUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponse(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail(),
                savedUser.getPhoneNumber(),
                savedUser.getCountry(),
                savedUser.getCreatedAt()
        );

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}