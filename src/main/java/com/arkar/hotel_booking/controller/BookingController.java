package com.arkar.hotel_booking.controller;

import com.arkar.hotel_booking.entity.Booking;
import com.arkar.hotel_booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }

    @DeleteMapping("/{id}")
    public void cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
    }
}