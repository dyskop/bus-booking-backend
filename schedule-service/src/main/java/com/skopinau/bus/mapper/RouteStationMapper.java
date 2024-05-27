package com.skopinau.bus.mapper;

import com.skopinau.bus.dto.RouteStationDto;
import com.skopinau.bus.entity.RouteStation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RouteStationMapper {

    @Mapping(target = "id", source = "station.id")
    @Mapping(target = "name", source = "station.name")
    RouteStationDto mapToRouteStationDto(RouteStation routeStation);
}
