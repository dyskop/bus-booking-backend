package com.skopinau.schedule.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record RouteResponseDto(
        long id,
        List<RouteStationDto> stations
) {
}
