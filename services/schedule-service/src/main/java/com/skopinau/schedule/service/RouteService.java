package com.skopinau.schedule.service;

import com.skopinau.schedule.dto.RouteRequestDto;
import com.skopinau.schedule.dto.RouteResponseDto;
import com.skopinau.schedule.entity.Route;
import com.skopinau.schedule.entity.RouteStation;
import com.skopinau.schedule.entity.Station;
import com.skopinau.schedule.exception.RouteNotExistException;
import com.skopinau.schedule.mapper.RouteMapper;
import com.skopinau.schedule.repository.RouteRepository;
import com.skopinau.schedule.repository.RouteStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.skopinau.schedule.exception.message.ExceptionMessage.ROUTE_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteStationRepository routeStationRepository;
    private final StationService stationService;
    private final RouteMapper routeMapper;

    public List<RouteResponseDto> findAllRoutes() {
        return routeRepository.findAll().stream()
                .map(routeMapper::mapToRouteResponseDto)
                .toList();
    }

    @Transactional
    public RouteResponseDto saveRoute(RouteRequestDto routeRequestDto) {
        Route route = routeRepository.save(new Route());
        List<RouteStation> routeStations = getRouteStations(routeRequestDto, route.getId());
        route.setRouteStations(routeStations);
        return routeMapper.mapToRouteResponseDto(route);
    }

    public Route findById(Long id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> {
                    String message = String.format(ROUTE_NOT_EXIST.getMessage(), id);
                    throw new RouteNotExistException(message);
                });
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
}
