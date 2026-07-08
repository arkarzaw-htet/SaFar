package com.arkar.hotel_booking.repository;

import com.arkar.hotel_booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}