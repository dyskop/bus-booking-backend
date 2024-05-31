package com.skopinau.schedule.repository;

import com.skopinau.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository<T extends Schedule> extends JpaRepository<T, Long> {
}
