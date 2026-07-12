package com.arkar.hotel_booking.controller;

import com.arkar.hotel_booking.dto.hotel.HotelCreateRequest;
import com.arkar.hotel_booking.dto.hotel.HotelResponse;
import com.arkar.hotel_booking.dto.hotel.HotelSummaryResponse;
import com.arkar.hotel_booking.dto.hotel.HotelUpdateRequest;
import com.arkar.hotel_booking.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public HotelResponse createHotel(@RequestBody HotelCreateRequest request) {
        return hotelService.createHotel(request);
    }

    @GetMapping
    public List<HotelSummaryResponse> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public HotelResponse getHotel(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @PutMapping("/{id}")
    public HotelResponse updateHotel(
            @PathVariable Long id,
            @RequestBody HotelUpdateRequest request
    ) {
        return hotelService.updateHotel(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}