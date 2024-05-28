package com.skopinau.schedule.repository;

import com.skopinau.schedule.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long> {

    Optional<Station> findByName(String name);
}
