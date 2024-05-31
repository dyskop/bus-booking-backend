package com.skopinau.schedule.dto;

import lombok.Builder;

@Builder
public record StationDto(
        long id,
        String name
) {
}
