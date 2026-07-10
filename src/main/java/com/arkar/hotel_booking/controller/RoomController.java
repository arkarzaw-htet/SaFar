package com.arkar.hotel_booking.controller;

import com.arkar.hotel_booking.dto.room.RoomCreateRequest;
import com.arkar.hotel_booking.dto.room.RoomResponse;
import com.arkar.hotel_booking.dto.room.RoomSummaryResponse;
import com.arkar.hotel_booking.entity.Room;
import com.arkar.hotel_booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;


    @PostMapping
    public RoomResponse createRoom(@RequestBody RoomCreateRequest room) {
        return roomService.createRoom(room);
    }

    @GetMapping
    public List<RoomResponse> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public RoomResponse getRoom(@PathVariable Long id) {
        return roomService.getRoom(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}