package com.skopinau.schedule.repository;

import com.skopinau.schedule.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
