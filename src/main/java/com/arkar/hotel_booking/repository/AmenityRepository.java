package com.arkar.hotel_booking.repository;

import com.arkar.hotel_booking.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {

}