package com.skopinau.bus.exception;

public class RouteNotExistException extends RuntimeException {

    public RouteNotExistException(String message) {
        super(message);
    }
}
