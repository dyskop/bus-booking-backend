package com.skopinau.schedule.controller;

import com.skopinau.schedule.dto.BusDto;
import com.skopinau.schedule.service.BusService;
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
    public ResponseEntity<BusDto> createBus(@RequestBody BusDto busDto) {
        return new ResponseEntity<>(busService.saveBus(busDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDto> findBusById(@PathVariable long id) {
        return ResponseEntity.ok(busService.findBusDtoById(id));
    }
}


