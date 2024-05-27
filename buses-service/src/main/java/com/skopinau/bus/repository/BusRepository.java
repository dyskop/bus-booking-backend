package com.skopinau.bus.repository;

import com.skopinau.bus.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus, Long> {

    Optional<Bus> findByNumber(String number);
}
