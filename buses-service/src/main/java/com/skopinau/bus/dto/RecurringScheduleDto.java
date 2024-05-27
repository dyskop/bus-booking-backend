package com.skopinau.bus.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

public record RecurringScheduleDto(
        long routeId,
        long busId,
        LocalTime departureTime,
        LocalTime arrivalTime,
        Set<DayOfWeek> daysOfWeek
) {
}
