package com.skopinau.bus.booking.repository;

import com.skopinau.bus.booking.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus, Long> {

    Optional<Bus> findByRegistrationNumber(String number);
}
