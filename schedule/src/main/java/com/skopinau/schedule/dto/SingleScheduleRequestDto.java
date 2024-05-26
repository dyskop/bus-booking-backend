package com.skopinau.schedule.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SingleScheduleRequestDto(
        long routeId,
        long busId,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime
) {
}
