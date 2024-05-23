package com.skopinau.bus.dto;

import com.skopinau.bus.model.Amenity;
import lombok.Builder;

import java.util.List;

@Builder
public record BusDto(
        String number,
        String model,
        Integer capacity,
        List<Amenity> amenities
) {
}
