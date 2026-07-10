package com.arkar.hotel_booking.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class RoomResponse {

    private Long id;

    private String roomNumber;

    private String roomType;

    private Integer capacity;

    private Integer bedCount;

    private BigDecimal pricePerNight;

    private Boolean available;

    private Long hotelId;
}