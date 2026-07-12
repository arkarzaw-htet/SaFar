package com.arkar.hotel_booking.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelCreateRequest {

    private String name;

    private String description;

    private String address;

    private String city;

    private String country;

    private Double latitude;

    private Double longitude;

    private Integer starRating;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;

    private List<Long> amenityIds;
}