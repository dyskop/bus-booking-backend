package com.skopinau.schedule.dto;

import lombok.Builder;

@Builder
public record RouteStationDto(
        long id,
        String name,
        int sequence
) {
}
