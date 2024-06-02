package com.skopinau.bus.booking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public record BusRequest(
        long id,
        @NotBlank
        String registrationNumber,
        @NotBlank
        String model,
        @Positive
        int capacity,
        List<String> amenities
) {
}
