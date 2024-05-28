package com.skopinau.schedule.dto;

import com.skopinau.schedule.entity.Amenity;
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
