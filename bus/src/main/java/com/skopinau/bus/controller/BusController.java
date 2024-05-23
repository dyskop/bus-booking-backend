package com.skopinau.bus.controller;

import com.skopinau.bus.dto.BusDto;
import com.skopinau.bus.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buses")
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @GetMapping
    public ResponseEntity<List<BusDto>> findAllBuses() {
        return ResponseEntity.ok().body(busService.findAllBuses());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBus(
            @RequestBody BusDto busDto
    ) {
        busService.saveBus(busDto);
    }
}
