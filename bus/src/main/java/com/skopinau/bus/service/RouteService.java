package com.skopinau.bus.service;

import com.skopinau.bus.dto.RouteRequestDto;
import com.skopinau.bus.dto.RouteResponseDto;
import com.skopinau.bus.entity.Bus;
import com.skopinau.bus.entity.Route;
import com.skopinau.bus.entity.RouteStation;
import com.skopinau.bus.entity.Station;
import com.skopinau.bus.exception.RouteNotExistException;
import com.skopinau.bus.exception.message.ExceptionMessage;
import com.skopinau.bus.mapper.RouteMapper;
import com.skopinau.bus.repository.RouteRepository;
import com.skopinau.bus.repository.RouteStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteStationRepository routeStationRepository;
    private final BusService busService;
    private final StationService stationService;
    private final RouteMapper routeMapper;

    public List<RouteResponseDto> findAllRoutes() {
        return routeRepository.findAll().stream()
                .map(routeMapper::mapToRouteResponseDto)
                .toList();
    }

    @Transactional
    public RouteResponseDto saveRoute(RouteRequestDto routeRequestDto) {
        Route route = Route.builder()
                .buses(getBuses(routeRequestDto))
                .build();
        route = routeRepository.save(route);
        List<RouteStation> routeStations = getRouteStations(routeRequestDto, route.getId());
        route.setRouteStations(routeStations);
        return routeMapper.mapToRouteResponseDto(route);
    }

    public Route findById(Long id) {
        String message = String.format(ExceptionMessage.ROUTE_NOT_EXIST.getMessage(), id);
        return routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotExistException(message));
    }

    private List<RouteStation> getRouteStations(RouteRequestDto routeRequestDto, Long routeId) {
        LinkedList<String> stationNames = routeRequestDto.stationNames();
        List<RouteStation> routeStations = new ArrayList<>();
        for (int i = 0; i < stationNames.size(); i++) {
            Station station = stationService.findStationByName(stationNames.get(i));
            RouteStation routeStation = RouteStation.builder()
                    .station(station)
                    .route(findById(routeId))
                    .sequence(i)
                    .build();
            routeStation = routeStationRepository.save(routeStation);
            routeStations.add(routeStation);
        }
        return routeStations;
    }

    private List<Bus> getBuses(RouteRequestDto routeRequestDto) {
        Set<String> busNumbers = routeRequestDto.busNumbers();
        return busNumbers.stream()
                .map(busService::findByNumber)
                .toList();
    }
}
