package com.arkar.hotel_booking.exception;

public class RoomNotFoundException extends  RuntimeException {
    public RoomNotFoundException(Long id) {
        super("Room with" + id +"not found");
    }
}
