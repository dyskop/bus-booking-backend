package com.skopinau.bus.controller;

import com.skopinau.bus.entity.Amenity;
import com.skopinau.bus.service.AmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/amenities")
public class AmenityController {

    private final AmenityService amenityService;

    @GetMapping
    public ResponseEntity<List<Amenity>> findAllAmenities() {
        return ResponseEntity.ok(amenityService.findAll());
    }

    @PostMapping
    public ResponseEntity<Amenity> createAmenity(@RequestParam String name) {
        return new ResponseEntity<>(amenityService.createAmenity(name), HttpStatus.CREATED);
    }
}
