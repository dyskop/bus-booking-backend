package com.skopinau.bus.booking.service;

import com.skopinau.bus.booking.dto.AmenityRequest;
import com.skopinau.bus.booking.dto.AmenityResponse;
import com.skopinau.bus.booking.entity.Amenity;
import com.skopinau.bus.booking.exception.AmenityAlreadyExistsException;
import com.skopinau.bus.booking.exception.AmenityNotFoundException;
import com.skopinau.bus.booking.mapper.AmenityMapper;
import com.skopinau.bus.booking.repository.AmenityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.skopinau.bus.booking.exception.message.ExceptionMessage.AMENITY_ALREADY_EXISTS;
import static com.skopinau.bus.booking.exception.message.ExceptionMessage.AMENITY_NOT_FOUND;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class AmenityService {

    private final AmenityRepository amenityRepository;
    private final AmenityMapper amenityMapper;

    public Long create(AmenityRequest request) {
        amenityRepository.findByName(request.name()).ifPresent(
                amenity -> {
                    String message = format(AMENITY_ALREADY_EXISTS.getMessage(), request.name());
                    throw new AmenityAlreadyExistsException(message);
                }
        );
        Amenity amenity = amenityMapper.toAmenity(request);
        amenity = amenityRepository.save(amenity);
        return amenity.getId();
    }

    public void update(AmenityRequest request) {
        Amenity amenity = amenityRepository.findById(request.id()).orElseThrow(() -> {
            String message = format(AMENITY_NOT_FOUND.getMessage(), request.id());
            throw new AmenityNotFoundException(message);
        });
        mergeAmenity(amenity, request);
        amenityRepository.save(amenity);
    }

    public List<AmenityResponse> findAll() {
        return amenityRepository.findAll()
                .stream()
                .map(amenityMapper::toAmenityResponse)
                .collect(Collectors.toList());
    }

    public AmenityResponse findById(long id) {
        return amenityRepository.findById(id)
                .map(amenityMapper::toAmenityResponse)
                .orElseThrow(() -> {
            String message = format(AMENITY_NOT_FOUND.getMessage(), id);
            throw new AmenityNotFoundException(message);
        });
    }

    public Amenity findByName(String name) {
        return amenityRepository.findByName(name)
                .orElseThrow(() -> {
                    String message = format(AMENITY_NOT_FOUND.getMessage(), name);
                    throw new AmenityNotFoundException(message);
                });
    }

    public boolean existsById(long id) {
        return amenityRepository.existsById(id);
    }

    public void deleteById(long id) {
        amenityRepository.deleteById(id);
    }

    private void mergeAmenity(Amenity amenity, AmenityRequest request) {
        if (StringUtils.isNotBlank(request.name())) {
            amenity.setName(request.name());
        }
    }
}
