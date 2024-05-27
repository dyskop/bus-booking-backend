package com.skopinau.bus.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SingleScheduleDto(
        long routeId,
        long busId,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime
) {
}
