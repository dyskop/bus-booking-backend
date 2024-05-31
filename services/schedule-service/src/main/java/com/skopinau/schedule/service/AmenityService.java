package com.skopinau.schedule.service;

import com.skopinau.schedule.entity.Amenity;
import com.skopinau.schedule.exception.AmenityAlreadyExistException;
import com.skopinau.schedule.repository.AmenityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.skopinau.schedule.exception.message.ExceptionMessage.AMENITY_ALREADY_EXIST;

@Service
@RequiredArgsConstructor
public class AmenityService {

    private final AmenityRepository amenityRepository;

    public List<Amenity> findAll() {
        return amenityRepository.findAll();
    }

    @Transactional
    public Amenity createAmenity(String name) {
        Optional<Amenity> amenityOptional = amenityRepository.findByName(name);
        amenityOptional.ifPresent(amenity -> {
            String message = String.format(AMENITY_ALREADY_EXIST.getMessage(), name);
            throw new AmenityAlreadyExistException(message);
        });
        Amenity amenity = Amenity.builder()
                .name(name)
                .build();
        return amenityRepository.save(amenity);
    }
}
