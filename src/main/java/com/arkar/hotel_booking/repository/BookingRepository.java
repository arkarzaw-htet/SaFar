package com.arkar.hotel_booking.repository;

import com.arkar.hotel_booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
