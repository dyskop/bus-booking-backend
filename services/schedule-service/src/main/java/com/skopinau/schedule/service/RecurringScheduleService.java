package com.skopinau.schedule.service;

import com.skopinau.schedule.dto.RecurringScheduleDto;
import com.skopinau.schedule.entity.Bus;
import com.skopinau.schedule.entity.RecurringSchedule;
import com.skopinau.schedule.entity.Route;
import com.skopinau.schedule.mapper.RecurringScheduleMapper;
import com.skopinau.schedule.repository.RecurringScheduleRepository;
import com.skopinau.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class RecurringScheduleService extends ScheduleService<RecurringSchedule> {

    private final RecurringScheduleRepository recurringScheduleRepository;
    private final RouteService routeService;
    private final BusService busService;
    private final RecurringScheduleMapper recurringScheduleMapper;

    public RecurringScheduleService(
            ScheduleRepository<RecurringSchedule> scheduleRepository,
            RecurringScheduleRepository recurringScheduleRepository,
            RouteService routeService,
            BusService busService,
            RecurringScheduleMapper recurringScheduleMapper) {
        super(scheduleRepository);
        this.recurringScheduleRepository = recurringScheduleRepository;
        this.routeService = routeService;
        this.busService = busService;
        this.recurringScheduleMapper = recurringScheduleMapper;
    }

    public RecurringScheduleDto createRecurringSchedule(RecurringScheduleDto dto) {
        Route route = routeService.findById(dto.routeId());
        Bus bus = busService.findBusById(dto.busId());

        RecurringSchedule recurringSchedule = RecurringSchedule.builder()
                .route(route)
                .bus(bus)
                .departureTime(dto.departureTime())
                .arrivalTime(dto.arrivalTime())
                .daysOfWeek(dto.daysOfWeek())
                .build();
        recurringSchedule = recurringScheduleRepository.save(recurringSchedule);
        return recurringScheduleMapper.mapToRecurringScheduleDto(recurringSchedule);
    }
}
