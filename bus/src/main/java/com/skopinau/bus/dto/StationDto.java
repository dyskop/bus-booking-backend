package com.skopinau.bus.dto;

import lombok.Builder;

@Builder
public record StationDto(
        long id,
        String name,
        int sequence
) {
}
