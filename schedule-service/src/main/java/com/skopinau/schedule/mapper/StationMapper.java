package com.skopinau.schedule.mapper;

import com.skopinau.schedule.dto.StationDto;
import com.skopinau.schedule.entity.Station;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StationMapper {

    StationDto mapToStationDto(Station station);
}
