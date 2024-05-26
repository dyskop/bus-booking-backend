package com.skopinau.schedule.repository;

import com.skopinau.schedule.entity.BusAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusAssignmentRepository extends JpaRepository<BusAssignment, Long> {
}
