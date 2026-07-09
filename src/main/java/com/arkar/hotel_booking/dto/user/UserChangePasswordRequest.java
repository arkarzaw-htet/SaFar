package com.arkar.hotel_booking.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserChangePasswordRequest {

    private String oldPassword;

    private String newPassword;
}