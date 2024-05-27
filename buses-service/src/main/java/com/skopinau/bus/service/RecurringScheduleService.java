package com.skopinau.bus.service;

import com.skopinau.bus.dto.RecurringScheduleDto;
import com.skopinau.bus.entity.Bus;
import com.skopinau.bus.entity.RecurringSchedule;
import com.skopinau.bus.entity.Route;
import com.skopinau.bus.mapper.RecurringScheduleMapper;
import com.skopinau.bus.repository.RecurringScheduleRepository;
import com.skopinau.bus.repository.ScheduleRepository;
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
