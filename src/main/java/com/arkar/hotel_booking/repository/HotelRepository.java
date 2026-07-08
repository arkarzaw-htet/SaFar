package com.arkar.hotel_booking.repository;

import com.arkar.hotel_booking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
