package com.skopinau.bus.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {

    AMENITY_NOT_EXIST("Invalid amenity: %s");

    private final String message;
}
