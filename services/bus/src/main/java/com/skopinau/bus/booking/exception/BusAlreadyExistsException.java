package com.skopinau.bus.booking.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
public class BusAlreadyExistsException extends RuntimeException {

    private final String message;
}
