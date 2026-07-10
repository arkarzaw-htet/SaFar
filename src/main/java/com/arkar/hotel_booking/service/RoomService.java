package com.arkar.hotel_booking.service;

import com.arkar.hotel_booking.dto.room.RoomCreateRequest;
import com.arkar.hotel_booking.dto.room.RoomResponse;
import com.arkar.hotel_booking.dto.room.RoomUpdateRequest;
import com.arkar.hotel_booking.entity.Hotel;
import com.arkar.hotel_booking.entity.Room;
import com.arkar.hotel_booking.repository.HotelRepository;
import com.arkar.hotel_booking.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomResponse createRoom(RoomCreateRequest request) {

        Hotel hotel = hotelRepository.findById(request.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        Room room = new Room();

        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(request.getRoomType());
        room.setCapacity(request.getCapacity());
        room.setBedCount(request.getBedCount());
        room.setPricePerNight(request.getPricePerNight());
        room.setAvailable(request.getAvailable());
        room.setHotel(hotel);

        Room savedRoom = roomRepository.save(room);

        return mapToResponse(savedRoom);
    }

    public List<RoomResponse> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public RoomResponse getRoom(Long id) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        return mapToResponse(room);
    }

    public RoomResponse updateRoom(Long id, RoomUpdateRequest request) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(request.getRoomType());
        room.setCapacity(request.getCapacity());
        room.setBedCount(request.getBedCount());
        room.setPricePerNight(request.getPricePerNight());
        room.setAvailable(request.getAvailable());

        Room updatedRoom = roomRepository.save(room);

        return mapToResponse(updatedRoom);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    private RoomResponse mapToResponse(Room room) {

        return new RoomResponse(
                room.getId(),
                room.getRoomNumber(),
                room.getRoomType(),
                room.getCapacity(),
                room.getBedCount(),
                room.getPricePerNight(),
                room.getAvailable(),
                room.getHotel().getId()
        );
    }
}