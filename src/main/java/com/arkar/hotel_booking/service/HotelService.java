package com.arkar.hotel_booking.service;

import com.arkar.hotel_booking.entity.Hotel;
import com.arkar.hotel_booking.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {

        Hotel hotel = getHotelById(id);

        hotel.setName(updatedHotel.getName());
        hotel.setDescription(updatedHotel.getDescription());
        hotel.setAddress(updatedHotel.getAddress());
        hotel.setCity(updatedHotel.getCity());
        hotel.setCountry(updatedHotel.getCountry());
        hotel.setLatitude(updatedHotel.getLatitude());
        hotel.setLongitude(updatedHotel.getLongitude());
        hotel.setStarRating(updatedHotel.getStarRating());
        hotel.setCheckInTime(updatedHotel.getCheckInTime());
        hotel.setCheckOutTime(updatedHotel.getCheckOutTime());

        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}