package com.skopinau.bus.booking.controller;

import com.skopinau.bus.booking.dto.AmenityRequest;
import com.skopinau.bus.booking.dto.AmenityResponse;
import com.skopinau.bus.booking.service.AmenityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/amenities")
@RequiredArgsConstructor
public class AmenityController {

    private final AmenityService amenityService;

    @PostMapping
    public ResponseEntity<Long> createAmenity(
            @RequestBody @Valid AmenityRequest request
    ) {
        return ResponseEntity.status(CREATED)
                .body(amenityService.create(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateAmenity(
            @RequestBody @Valid AmenityRequest request
    ) {
        amenityService.update(request);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<AmenityResponse>> findAllAmenities() {
        return ResponseEntity.status(OK)
                .body(amenityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmenityResponse> findAmenityById(
            @PathVariable long id
    ) {
        return ResponseEntity.status(OK)
                .body(amenityService.findById(id));
    }

    @GetMapping("/existence/{id}")
    public ResponseEntity<Boolean> amenityExistsById(
            @PathVariable long id
    ) {
        return ResponseEntity.status(OK)
                .body(amenityService.existsById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmenityById(
            @PathVariable long id
    ) {
        amenityService.deleteById(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
