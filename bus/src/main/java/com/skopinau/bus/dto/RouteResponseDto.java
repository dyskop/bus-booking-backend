package com.skopinau.bus.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record RouteResponseDto(
        long id,
        List<StationDto> stations,
        List<BusDto> buses
) {
}
