package com.skopinau.bus.service;

import com.skopinau.bus.entity.Route;
import com.skopinau.bus.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    public List<Route> findAllRoutes() {
        return routeRepository.findAll();
    }
}
