package com.skopinau.bus.booking.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record AmenityRequest(
        @NotNull
        String name
) {
}
