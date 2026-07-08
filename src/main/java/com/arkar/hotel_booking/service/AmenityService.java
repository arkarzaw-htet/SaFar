package com.arkar.hotel_booking.service;

import com.arkar.hotel_booking.entity.Amenity;
import com.arkar.hotel_booking.repository.AmenityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmenityService {

    private final AmenityRepository amenityRepository;

    public Amenity createAmenity(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();
    }
}