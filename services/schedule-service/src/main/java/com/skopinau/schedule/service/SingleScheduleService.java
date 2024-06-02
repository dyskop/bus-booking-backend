package com.skopinau.schedule.service;

import com.skopinau.schedule.dto.SingleScheduleDto;
import com.skopinau.schedule.entity.Bus;
import com.skopinau.schedule.entity.Route;
import com.skopinau.schedule.entity.SingleSchedule;
import com.skopinau.schedule.mapper.SingleScheduleMapper;
import com.skopinau.schedule.repository.ScheduleRepository;
import com.skopinau.schedule.repository.SingleScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SingleScheduleService extends ScheduleService<SingleSchedule> {

    private final SingleScheduleRepository singleScheduleRepository;
    private final RouteService routeService;
    private final BusService busService;
    private final SingleScheduleMapper singleScheduleMapper;

    public SingleScheduleService(
            ScheduleRepository<SingleSchedule> scheduleRepository,
            SingleScheduleRepository singleScheduleRepository,
            RouteService routeService,
            BusService busService,
            SingleScheduleMapper singleScheduleMapper) {
        super(scheduleRepository);
        this.singleScheduleRepository = singleScheduleRepository;
        this.routeService = routeService;
        this.busService = busService;
        this.singleScheduleMapper = singleScheduleMapper;
    }

    @Transactional
    public SingleScheduleDto createSingleSchedule(SingleScheduleDto dto) {
        Route route = routeService.findById(dto.routeId());
        Bus bus = busService.findBusById(dto.busId());

        SingleSchedule singleSchedule = SingleSchedule.builder()
                .route(route)
                .bus(bus)
                .departureTime(dto.departureTime())
                .arrivalTime(dto.arrivalTime())
                .build();
        singleSchedule = singleScheduleRepository.save(singleSchedule);
        return singleScheduleMapper.mapToSingleScheduleDto(singleSchedule);
    }
}
