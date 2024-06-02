package com.skopinau.bus.booking.controller;

import com.skopinau.bus.booking.dto.BusRequest;
import com.skopinau.bus.booking.dto.BusResponse;
import com.skopinau.bus.booking.service.BusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/buses")
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @PostMapping
    public ResponseEntity<Long> createBus(
            @RequestBody @Valid BusRequest request
    ) {
        return ResponseEntity.status(CREATED)
                .body(busService.create(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateBus(
            @RequestBody @Valid BusRequest request
    ) {
        busService.update(request);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<BusResponse>> findAllBuses() {
        return ResponseEntity.status(OK)
                .body(busService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusResponse> findBusById(
            @PathVariable long id
    ) {
        return ResponseEntity.status(OK)
                .body(busService.findById(id));
    }

    @GetMapping("/existence/{id}")
    public ResponseEntity<Boolean> busExistsById(
            @PathVariable long id
    ) {
        return ResponseEntity.status(OK)
                .body(busService.existsById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusById(
            @PathVariable long id
    ) {
        busService.deleteById(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
