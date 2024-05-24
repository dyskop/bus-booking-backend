package com.skopinau.bus.repository;

import com.skopinau.bus.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {

    Optional<Amenity> findByName(String name);
}
