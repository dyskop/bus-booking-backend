package com.skopinau.schedule.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(name = "recurring_schedule")
public class RecurringSchedule extends Schedule {

    @ElementCollection(targetClass = DayOfWeek.class)
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "recurring_schedule_days", joinColumns = @JoinColumn(name = "recurring_schedule_id"))
    @Column(name = "day_of_week")
    private Set<DayOfWeek> daysOfWeek;

    @Column(nullable = false)
    private LocalTime departureTime;

    @Column(nullable = false)
    private LocalTime arrivalTime;
}
