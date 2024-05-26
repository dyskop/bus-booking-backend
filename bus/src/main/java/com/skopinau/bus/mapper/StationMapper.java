package com.skopinau.bus.mapper;

import com.skopinau.bus.dto.StationDto;
import com.skopinau.bus.entity.Station;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StationMapper {

    StationDto mapToStationDto(Station station);
}
