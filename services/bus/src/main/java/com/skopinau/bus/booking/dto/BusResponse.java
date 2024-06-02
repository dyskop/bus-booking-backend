package com.skopinau.bus.booking.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record BusResponse(
        long id,
        String registrationNumber,
        String model,
        int capacity,
        List<AmenityResponse> amenities
) {
}
