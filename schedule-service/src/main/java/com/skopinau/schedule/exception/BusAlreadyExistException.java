package com.skopinau.schedule.exception;

public class BusAlreadyExistException extends RuntimeException {

    public BusAlreadyExistException(String message) {
        super(message);
    }
}
