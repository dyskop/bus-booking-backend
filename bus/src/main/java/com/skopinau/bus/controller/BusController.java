package com.skopinau.bus.controller;

import com.skopinau.bus.dto.BusDto;
import com.skopinau.bus.entity.Bus;
import com.skopinau.bus.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/buses")
public class BusController {

    private final BusService busService;

    @GetMapping
    public ResponseEntity<List<BusDto>> findAllBuses() {
        return ResponseEntity.ok(busService.findAllBuses());
    }

    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody BusDto busDto) {
        return new ResponseEntity<>(busService.saveBus(busDto), HttpStatus.CREATED);
    }
}


