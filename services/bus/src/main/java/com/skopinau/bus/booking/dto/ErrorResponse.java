package com.skopinau.bus.booking.dto;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
