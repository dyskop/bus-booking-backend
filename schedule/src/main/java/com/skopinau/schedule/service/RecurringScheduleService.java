package com.skopinau.schedule.service;

import com.skopinau.schedule.entity.RecurringSchedule;
import com.skopinau.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class RecurringScheduleService extends ScheduleService<RecurringSchedule> {

    public RecurringScheduleService(ScheduleRepository<RecurringSchedule> scheduleRepository) {
        super(scheduleRepository);
    }
}
