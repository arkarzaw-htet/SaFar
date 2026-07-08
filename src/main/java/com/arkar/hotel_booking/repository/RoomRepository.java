package com.arkar.hotel_booking.repository;

import com.arkar.hotel_booking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
