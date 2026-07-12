package com.arkar.hotel_booking.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingCreateRequest {

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Integer guestCount;

    private Long userId;

    private Long roomId;
}