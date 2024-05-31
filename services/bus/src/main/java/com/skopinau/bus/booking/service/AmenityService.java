package com.skopinau.bus.booking.service;

import com.skopinau.bus.booking.dto.AmenityRequest;
import com.skopinau.bus.booking.entity.Amenity;
import com.skopinau.bus.booking.exception.AmenityAlreadyExistsException;
import com.skopinau.bus.booking.repository.AmenityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.skopinau.bus.booking.exception.ExceptionMessage.AMENITY_ALREADY_EXISTS;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class AmenityService {

    private final AmenityRepository amenityRepository;

    @Transactional
    public Long create(AmenityRequest request) {
        amenityRepository.findByName(request.name()).ifPresent(
                amenity -> {
                    String message = format(AMENITY_ALREADY_EXISTS.getMessage(), request.name());
                    throw new AmenityAlreadyExistsException(message);
                }
        );
        Amenity amenity = Amenity.builder()
                .name(request.name())
                .build();
        amenity = amenityRepository.save(amenity);
        return amenity.getId();
    }
}
