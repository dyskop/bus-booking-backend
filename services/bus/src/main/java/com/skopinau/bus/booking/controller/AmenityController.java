package com.skopinau.bus.booking.controller;

import com.skopinau.bus.booking.dto.AmenityRequest;
import com.skopinau.bus.booking.service.AmenityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/amenities")
@RequiredArgsConstructor
public class AmenityController {

    private final AmenityService amenityService;

    @PostMapping
    public ResponseEntity<Long> createAmenity(
            @RequestBody @Valid AmenityRequest request
    ) {
        return ResponseEntity
                .status(CREATED)
                .body(amenityService.create(request));
    }
}
