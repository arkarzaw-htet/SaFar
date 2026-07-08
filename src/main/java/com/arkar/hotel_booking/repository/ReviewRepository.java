package com.arkar.hotel_booking.repository;

import com.arkar.hotel_booking.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
