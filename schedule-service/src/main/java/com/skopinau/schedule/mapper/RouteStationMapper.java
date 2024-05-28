package com.skopinau.schedule.mapper;

import com.skopinau.schedule.dto.RouteStationDto;
import com.skopinau.schedule.entity.RouteStation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RouteStationMapper {

    @Mapping(target = "id", source = "station.id")
    @Mapping(target = "name", source = "station.name")
    RouteStationDto mapToRouteStationDto(RouteStation routeStation);
}
