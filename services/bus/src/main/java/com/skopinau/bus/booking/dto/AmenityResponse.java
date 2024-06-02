package com.skopinau.bus.booking.dto;

import lombok.Builder;

@Builder
public record AmenityResponse(
        long id,
        String name
) {
}
