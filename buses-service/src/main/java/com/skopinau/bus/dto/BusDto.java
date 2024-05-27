package com.skopinau.bus.dto;

import com.skopinau.bus.entity.Amenity;
import lombok.Builder;

import java.util.Set;

@Builder
public record BusDto(
        long id,
        String number,
        String model,
        int capacity,
        Set<Amenity> amenities
) {
}
