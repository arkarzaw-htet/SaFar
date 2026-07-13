package com.arkar.hotel_booking.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @Pattern(
            regexp = "^[0-9+\\- ]+$",
            message = "Invalid phone number"
    )
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    @NotBlank(message = "Country  is required")
    private String country;
}