package com.arkar.hotel_booking.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomCreateRequest {

    private String roomNumber;

    private String roomType;

    private Integer capacity;

    private Integer bedCount;

    private BigDecimal pricePerNight;

    private Boolean available;

    private Long hotelId;
}