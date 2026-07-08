package com.arkar.hotel_booking.controller;

import com.arkar.hotel_booking.entity.Hotel;
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
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.createHotel(hotel);
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id,
                             @RequestBody Hotel hotel) {
        return hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}