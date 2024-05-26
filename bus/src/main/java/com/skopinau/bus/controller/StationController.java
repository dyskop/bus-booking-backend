package com.skopinau.bus.controller;

import com.skopinau.bus.dto.StationDto;
import com.skopinau.bus.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stations")
public class StationController {

    private final StationService stationService;

    @GetMapping
    public ResponseEntity<List<StationDto>> findAllStations() {
        return ResponseEntity.ok(stationService.findAllStations());
    }

    @PostMapping
    public ResponseEntity<StationDto> createStation(
            @RequestBody StationDto stationDto
    ) {
        return new ResponseEntity<>(stationService.createStation(stationDto), HttpStatus.CREATED);
    }
}
