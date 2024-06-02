package com.skopinau.bus.booking.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMessage {

    AMENITY_ALREADY_EXISTS("Amenity already exists: %s"),
    AMENITY_NOT_FOUND("Amenity not found: %d");

    private final String message;
}
