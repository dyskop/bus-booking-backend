package com.skopinau.bus.controller;

import com.skopinau.bus.dto.RouteRequestDto;
import com.skopinau.bus.dto.RouteResponseDto;
import com.skopinau.bus.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/routes")
public class RouteController {

    private final RouteService routeService;

    @GetMapping
    public ResponseEntity<List<RouteResponseDto>> findAllRoutes() {
        return ResponseEntity.ok(routeService.findAllRoutes());
    }

    @PostMapping
    public ResponseEntity<RouteResponseDto> createRoute(@RequestBody RouteRequestDto routeRequestDto) {
        return new ResponseEntity<>(routeService.saveRoute(routeRequestDto), HttpStatus.CREATED);
    }
}
