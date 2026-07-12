package com.arkar.hotel_booking.dto.booking;

import com.arkar.hotel_booking.entity.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookingResponse {

    private Long id;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Integer guestCount;

    private BookingStatus status;

    private BigDecimal totalPrice;

    private Long userId;

    private Long roomId;
}