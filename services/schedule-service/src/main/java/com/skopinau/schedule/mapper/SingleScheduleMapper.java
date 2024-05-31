package com.skopinau.schedule.mapper;

import com.skopinau.schedule.dto.SingleScheduleDto;
import com.skopinau.schedule.entity.SingleSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SingleScheduleMapper {

    @Mapping(target = "routeId", source = "route.id")
    @Mapping(target = "busId", source = "bus.id")
    SingleScheduleDto mapToSingleScheduleDto(SingleSchedule singleSchedule);
}
