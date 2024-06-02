package com.skopinau.bus.booking.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMessage {

    AMENITY_ALREADY_EXISTS("Amenity already exists: %s"),
    AMENITY_NOT_FOUND("Amenity not found: %s"),
    BUS_ALREADY_EXISTS("Bus already exists: %s"),
    BUS_NOT_FOUND("Bus not found: %s");

    private final String message;
}
