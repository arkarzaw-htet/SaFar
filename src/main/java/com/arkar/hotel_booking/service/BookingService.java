package com.arkar.hotel_booking.service;

import com.arkar.hotel_booking.dto.booking.BookingCreateRequest;
import com.arkar.hotel_booking.dto.booking.BookingResponse;
import com.arkar.hotel_booking.dto.booking.BookingSummaryResponse;
import com.arkar.hotel_booking.dto.booking.BookingUpdateRequest;
import com.arkar.hotel_booking.entity.Booking;
import com.arkar.hotel_booking.entity.BookingStatus;
import com.arkar.hotel_booking.entity.Room;
import com.arkar.hotel_booking.entity.User;
import com.arkar.hotel_booking.repository.BookingRepository;
import com.arkar.hotel_booking.repository.RoomRepository;
import com.arkar.hotel_booking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public BookingResponse createBooking(BookingCreateRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        long nights = ChronoUnit.DAYS.between(
                request.getCheckInDate(),
                request.getCheckOutDate()
        );

        BigDecimal totalPrice = room.getPricePerNight()
                .multiply(BigDecimal.valueOf(nights));

        Booking booking = new Booking();

        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        booking.setGuestCount(request.getGuestCount());
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setTotalPrice(totalPrice);
        booking.setUser(user);
        booking.setRoom(room);

        Booking savedBooking = bookingRepository.save(booking);

        return mapToResponse(savedBooking);
    }

    public List<BookingSummaryResponse> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::mapToSummaryResponse)
                .toList();
    }

    public BookingResponse getBooking(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        return mapToResponse(booking);
    }

    public BookingResponse updateBooking(Long id, BookingUpdateRequest request) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        booking.setGuestCount(request.getGuestCount());
        booking.setStatus(request.getStatus());

        long nights = ChronoUnit.DAYS.between(
                request.getCheckInDate(),
                request.getCheckOutDate()
        );

        BigDecimal totalPrice = booking.getRoom()
                .getPricePerNight()
                .multiply(BigDecimal.valueOf(nights));

        booking.setTotalPrice(totalPrice);

        Booking updatedBooking = bookingRepository.save(booking);

        return mapToResponse(updatedBooking);
    }

    public void cancelBooking(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(BookingStatus.CANCELLED);

        bookingRepository.save(booking);
    }

    private BookingResponse mapToResponse(Booking booking) {

        return new BookingResponse(
                booking.getId(),
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getGuestCount(),
                booking.getStatus(),
                booking.getTotalPrice(),
                booking.getUser().getId(),
                booking.getRoom().getId()
        );
    }

    private BookingSummaryResponse mapToSummaryResponse(Booking booking) {

        return new BookingSummaryResponse(
                booking.getId(),
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getStatus()
        );
    }
}