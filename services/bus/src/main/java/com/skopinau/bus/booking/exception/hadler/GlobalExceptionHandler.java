package com.skopinau.bus.booking.exception.hadler;

import com.skopinau.bus.booking.dto.ErrorResponse;
import com.skopinau.bus.booking.exception.AmenityAlreadyExistsException;
import com.skopinau.bus.booking.exception.AmenityNotFoundException;
import com.skopinau.bus.booking.exception.BusAlreadyExistsException;
import com.skopinau.bus.booking.exception.BusNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors()
                .forEach(error -> {
                    String field = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    errors.put(field, message);
                });
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new ErrorResponse(errors));
    }

    @ExceptionHandler(AmenityAlreadyExistsException.class)
    public ResponseEntity<String> handle(AmenityAlreadyExistsException e) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(AmenityNotFoundException.class)
    public ResponseEntity<String> handle(AmenityNotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(BusAlreadyExistsException.class)
    public ResponseEntity<String> handle(BusAlreadyExistsException e) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(BusNotFoundException.class)
    public ResponseEntity<String> handle(BusNotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(e.getMessage());
    }
}
