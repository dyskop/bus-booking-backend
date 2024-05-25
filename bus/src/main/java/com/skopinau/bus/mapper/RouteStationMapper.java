package com.skopinau.bus.mapper;

import com.skopinau.bus.dto.StationDto;
import com.skopinau.bus.entity.RouteStation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RouteStationMapper {

    @Mapping(target = "id", source = "station.id")
    @Mapping(target = "name", source = "station.name")
    StationDto mapToStationDto(RouteStation routeStation);
}
