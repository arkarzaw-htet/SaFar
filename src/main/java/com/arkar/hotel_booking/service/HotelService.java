package com.arkar.hotel_booking.service;

import com.arkar.hotel_booking.dto.hotel.HotelCreateRequest;
import com.arkar.hotel_booking.dto.hotel.HotelResponse;
import com.arkar.hotel_booking.dto.hotel.HotelSummaryResponse;
import com.arkar.hotel_booking.dto.hotel.HotelUpdateRequest;
import com.arkar.hotel_booking.entity.Amenity;
import com.arkar.hotel_booking.entity.Hotel;
import com.arkar.hotel_booking.repository.AmenityRepository;
import com.arkar.hotel_booking.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final AmenityRepository amenityRepository;

    public HotelResponse createHotel(HotelCreateRequest request) {

        Hotel hotel = new Hotel();

        hotel.setName(request.getName());
        hotel.setDescription(request.getDescription());
        hotel.setAddress(request.getAddress());
        hotel.setCity(request.getCity());
        hotel.setCountry(request.getCountry());
        hotel.setLatitude(request.getLatitude());
        hotel.setLongitude(request.getLongitude());
        hotel.setStarRating(request.getStarRating());
        hotel.setCheckInTime(request.getCheckInTime());
        hotel.setCheckOutTime(request.getCheckOutTime());

        if (request.getAmenityIds() != null) {
            List<Amenity> amenities =
                    amenityRepository.findAllById(request.getAmenityIds());
            hotel.setAmenities(amenities);
        }

        Hotel savedHotel = hotelRepository.save(hotel);

        return mapToResponse(savedHotel);
    }

    public List<HotelSummaryResponse> getAllHotels() {

        return hotelRepository.findAll()
                .stream()
                .map(this::mapToSummaryResponse)
                .toList();
    }

    public HotelResponse getHotelById(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        return mapToResponse(hotel);
    }

    public HotelResponse updateHotel(Long id, HotelUpdateRequest request) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        hotel.setName(request.getName());
        hotel.setDescription(request.getDescription());
        hotel.setAddress(request.getAddress());
        hotel.setCity(request.getCity());
        hotel.setCountry(request.getCountry());
        hotel.setLatitude(request.getLatitude());
        hotel.setLongitude(request.getLongitude());
        hotel.setStarRating(request.getStarRating());
        hotel.setCheckInTime(request.getCheckInTime());
        hotel.setCheckOutTime(request.getCheckOutTime());

        if (request.getAmenityIds() != null) {
            List<Amenity> amenities =
                    amenityRepository.findAllById(request.getAmenityIds());
            hotel.setAmenities(amenities);
        }

        Hotel updatedHotel = hotelRepository.save(hotel);

        return mapToResponse(updatedHotel);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    private HotelResponse mapToResponse(Hotel hotel) {

        List<Long> amenityIds = hotel.getAmenities()
                .stream()
                .map(Amenity::getId)
                .toList();

        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getDescription(),
                hotel.getAddress(),
                hotel.getCity(),
                hotel.getCountry(),
                hotel.getLatitude(),
                hotel.getLongitude(),
                hotel.getStarRating(),
                hotel.getCheckInTime(),
                hotel.getCheckOutTime(),
                amenityIds
        );
    }

    private HotelSummaryResponse mapToSummaryResponse(Hotel hotel) {

        return new HotelSummaryResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getCity(),
                hotel.getCountry(),
                hotel.getStarRating()
        );
    }
}