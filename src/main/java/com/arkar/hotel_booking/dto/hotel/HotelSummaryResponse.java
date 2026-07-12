package com.arkar.hotel_booking.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelSummaryResponse {

    private Long id;

    private String name;

    private String city;

    private String country;

    private Integer starRating;
}