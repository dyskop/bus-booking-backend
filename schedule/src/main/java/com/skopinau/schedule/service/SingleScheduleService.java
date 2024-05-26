package com.skopinau.schedule.service;

import com.skopinau.schedule.client.BusClient;
import com.skopinau.schedule.dto.SingleScheduleRequestDto;
import com.skopinau.schedule.entity.BusAssignment;
import com.skopinau.schedule.entity.SingleSchedule;
import com.skopinau.schedule.repository.BusAssignmentRepository;
import com.skopinau.schedule.repository.ScheduleRepository;
import com.skopinau.schedule.repository.SingleScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SingleScheduleService extends ScheduleService<SingleSchedule> {

    private final BusClient busClient;
    private final SingleScheduleRepository singleScheduleRepository;
    private final BusAssignmentRepository busAssignmentRepository;

    public SingleScheduleService(ScheduleRepository<SingleSchedule> scheduleRepository, BusClient busClient, SingleScheduleRepository singleScheduleRepository, BusAssignmentRepository busAssignmentRepository) {
        super(scheduleRepository);
        this.busClient = busClient;
        this.singleScheduleRepository = singleScheduleRepository;
        this.busAssignmentRepository = busAssignmentRepository;
    }

    @Transactional
    public SingleSchedule createSingleSchedule(SingleScheduleRequestDto dto) {
        // todo: feign exception handling
        busClient.findBusById(dto.busId());

        BusAssignment busAssignment = BusAssignment.builder()
                .busId(dto.busId())
                .build();

        busAssignmentRepository.save(busAssignment);

        SingleSchedule singleSchedule = SingleSchedule.builder()
                .routeId(dto.routeId())
                .busAssignment(busAssignment)
                .departureTime(dto.departureTime())
                .arrivalTime(dto.arrivalTime())
                .build();

        return singleScheduleRepository.save(singleSchedule);
    }
}
