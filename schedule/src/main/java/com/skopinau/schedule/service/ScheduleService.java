package com.skopinau.schedule.service;

import com.skopinau.schedule.entity.Schedule;
import com.skopinau.schedule.repository.ScheduleRepository;
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
