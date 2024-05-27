package com.skopinau.bus.exception;

public class BusAlreadyExistException extends RuntimeException {

    public BusAlreadyExistException(String message) {
        super(message);
    }
}
