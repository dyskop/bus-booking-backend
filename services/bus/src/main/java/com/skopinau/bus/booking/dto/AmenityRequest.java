package com.skopinau.bus.booking.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record AmenityRequest(
        long id,
        @NotBlank
        String name
) {
}
