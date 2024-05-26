package com.skopinau.bus.mapper;

import com.skopinau.bus.dto.SingleScheduleDto;
import com.skopinau.bus.entity.SingleSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SingleScheduleMapper {

    @Mapping(target = "routeId", source = "route.id")
    @Mapping(target = "busId", source = "bus.id")
    SingleScheduleDto mapToSingleScheduleDto(SingleSchedule singleSchedule);
}
