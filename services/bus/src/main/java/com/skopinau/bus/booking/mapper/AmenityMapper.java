package com.skopinau.bus.booking.mapper;

import com.skopinau.bus.booking.dto.AmenityRequest;
import com.skopinau.bus.booking.dto.AmenityResponse;
import com.skopinau.bus.booking.entity.Amenity;
import org.springframework.stereotype.Component;

@Component
public class AmenityMapper {

    public Amenity toAmenity(AmenityRequest request) {
        if (request == null) {
            return null;
        }
        return Amenity.builder()
                .id(request.id())
                .name(request.name())
                .build();
    }

    public AmenityResponse toAmenityResponse(Amenity amenity) {
        if (amenity == null) {
            return null;
        }
        return AmenityResponse.builder()
                .id(amenity.getId())
                .name(amenity.getName())
                .build();
    }
}
