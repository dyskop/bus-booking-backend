package com.skopinau.bus.exception.handler;

import com.skopinau.bus.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AmenityNotExistException.class)
    public ResponseEntity<String> amenityNotExist(AmenityNotExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AmenityAlreadyExistException.class)
    public ResponseEntity<String> amenityAlreadyExist(AmenityAlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusAlreadyExistException.class)
    public ResponseEntity<String> busAlreadyExist(BusAlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusNotExistException.class)
    public ResponseEntity<String> busNotExist(BusNotExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RouteNotExistException.class)
    public ResponseEntity<String> routeNotExist(RouteNotExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StationNotExistException.class)
    public ResponseEntity<String> stationNotExist(StationNotExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StationAlreadyExistException.class)
    public ResponseEntity<String> stationAlreadyExist(StationAlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
