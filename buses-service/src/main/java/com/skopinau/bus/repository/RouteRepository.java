package com.skopinau.bus.repository;

import com.skopinau.bus.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
