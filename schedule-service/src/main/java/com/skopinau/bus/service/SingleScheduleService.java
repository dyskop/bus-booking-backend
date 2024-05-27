package com.skopinau.bus.service;

import com.skopinau.bus.dto.SingleScheduleDto;
import com.skopinau.bus.entity.Bus;
import com.skopinau.bus.entity.Route;
import com.skopinau.bus.entity.SingleSchedule;
import com.skopinau.bus.mapper.SingleScheduleMapper;
import com.skopinau.bus.repository.ScheduleRepository;
import com.skopinau.bus.repository.SingleScheduleRepository;
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
