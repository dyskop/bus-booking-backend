package com.skopinau.schedule.exception;

public class StationAlreadyExistException extends RuntimeException {

    public StationAlreadyExistException(String message) {
        super(message);
    }
}
