package com.skopinau.bus.mapper;

import com.skopinau.bus.dto.RecurringScheduleDto;
import com.skopinau.bus.entity.RecurringSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecurringScheduleMapper {

    @Mapping(target = "routeId", source = "route.id")
    @Mapping(target = "busId", source = "bus.id")
    RecurringScheduleDto mapToRecurringScheduleDto(RecurringSchedule recurringSchedule);
}
