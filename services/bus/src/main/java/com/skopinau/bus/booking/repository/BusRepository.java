package com.skopinau.bus.booking.repository;

import com.skopinau.bus.booking.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
