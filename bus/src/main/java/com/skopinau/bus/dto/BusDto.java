package com.skopinau.bus.dto;

import com.skopinau.bus.entity.Amenity;
import lombok.Builder;

import java.util.Set;

@Builder
public record BusDto(
        String number,
        String model,
        Integer capacity,
        Set<Amenity> amenities
) {
}
