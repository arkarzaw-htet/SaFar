package com.arkar.hotel_booking.dto.booking;

import com.arkar.hotel_booking.entity.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookingSummaryResponse {

    private Long id;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private BookingStatus status;
}