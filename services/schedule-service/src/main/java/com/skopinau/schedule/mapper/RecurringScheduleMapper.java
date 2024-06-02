package com.skopinau.schedule.mapper;

import com.skopinau.schedule.dto.RecurringScheduleDto;
import com.skopinau.schedule.entity.RecurringSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecurringScheduleMapper {

    @Mapping(target = "routeId", source = "route.id")
    @Mapping(target = "busId", source = "bus.id")
    RecurringScheduleDto mapToRecurringScheduleDto(RecurringSchedule recurringSchedule);
}
