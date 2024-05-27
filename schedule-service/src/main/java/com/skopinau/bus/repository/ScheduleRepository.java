package com.skopinau.bus.repository;

import com.skopinau.bus.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository<T extends Schedule> extends JpaRepository<T, Long> {
}
