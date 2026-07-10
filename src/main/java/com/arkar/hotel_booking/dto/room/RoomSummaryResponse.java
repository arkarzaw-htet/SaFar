package com.arkar.hotel_booking.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class RoomSummaryResponse {

    private Long id;

    private String roomNumber;

    private String roomType;

    private BigDecimal pricePerNight;

    private Boolean available;
}