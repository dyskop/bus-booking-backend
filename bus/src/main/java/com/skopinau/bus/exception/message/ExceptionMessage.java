package com.skopinau.bus.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {

    AMENITY_NOT_EXIST("Invalid amenity: %s"),
    INVALID_BUS_NUMBER("Invalid bus number: %s"),
    STATION_NOT_EXIST("Invalid station name: %s"),
    ROUTE_NOT_EXIST("Invalid route id: %d");

    private final String message;
}
