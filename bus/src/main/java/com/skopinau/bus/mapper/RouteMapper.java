package com.skopinau.bus.mapper;

import com.skopinau.bus.dto.RouteResponseDto;
import com.skopinau.bus.entity.Route;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BusMapper.class, RouteStationMapper.class})
public interface RouteMapper {

    @Mapping(target = "stations", source = "routeStations")
    RouteResponseDto mapToRouteResponseDto(Route route);
}
