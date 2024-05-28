package com.skopinau.schedule.mapper;

import com.skopinau.schedule.dto.RouteResponseDto;
import com.skopinau.schedule.entity.Route;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BusMapper.class, RouteStationMapper.class})
public interface RouteMapper {

    @Mapping(target = "stations", source = "routeStations")
    RouteResponseDto mapToRouteResponseDto(Route route);
}
