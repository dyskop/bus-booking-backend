package com.skopinau.schedule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bus_assignment")
public class BusAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "busAssignment", cascade = CascadeType.ALL)
    @JsonBackReference
    private Schedule schedule;

    @Column(nullable = false)
    private Long busId;
}
