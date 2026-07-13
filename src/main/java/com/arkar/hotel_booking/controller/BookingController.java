package com.arkar.hotel_booking.controller;

import com.arkar.hotel_booking.dto.booking.BookingCreateRequest;
import com.arkar.hotel_booking.dto.booking.BookingResponse;
import com.arkar.hotel_booking.dto.booking.BookingSummaryResponse;
import com.arkar.hotel_booking.dto.booking.BookingUpdateRequest;
import com.arkar.hotel_booking.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public BookingResponse createBooking(@Valid @RequestBody BookingCreateRequest request) {
        return bookingService.createBooking(request);
    }

    @GetMapping
    public List<BookingSummaryResponse> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public BookingResponse getBooking(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }

    @PutMapping("/{id}")
    public BookingResponse updateBooking(
            @PathVariable Long id,
            @Valid @RequestBody BookingUpdateRequest request
    ) {
        return bookingService.updateBooking(id, request);
    }

    @DeleteMapping("/{id}")
    public void cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
    }
}