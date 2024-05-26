package com.skopinau.bus.service;

import com.skopinau.bus.entity.Schedule;
import com.skopinau.bus.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService<T extends Schedule> {

    protected final ScheduleRepository<T> scheduleRepository;

    public List<T> findAllSchedules() {
        return scheduleRepository.findAll();
    }
}
