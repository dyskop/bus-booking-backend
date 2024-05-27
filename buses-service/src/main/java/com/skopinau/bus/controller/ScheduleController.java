package com.skopinau.bus.controller;

import com.skopinau.bus.dto.RecurringScheduleDto;
import com.skopinau.bus.dto.SingleScheduleDto;
import com.skopinau.bus.entity.RecurringSchedule;
import com.skopinau.bus.entity.Schedule;
import com.skopinau.bus.entity.SingleSchedule;
import com.skopinau.bus.service.RecurringScheduleService;
import com.skopinau.bus.service.ScheduleService;
import com.skopinau.bus.service.SingleScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedules")
public class ScheduleController {

    private final ScheduleService<Schedule> scheduleService;
    private final SingleScheduleService singleScheduleService;
    private final RecurringScheduleService recurringScheduleService;

    @GetMapping
    public ResponseEntity<List<Schedule>> findAllSchedules() {
        return ResponseEntity.ok(scheduleService.findAllSchedules());
    }

    @GetMapping("/single")
    public ResponseEntity<List<SingleSchedule>> findAllSingleSchedules() {
        return ResponseEntity.ok(singleScheduleService.findAllSchedules());
    }

    @GetMapping("/recurring")
    public ResponseEntity<List<RecurringSchedule>> findAllRecurringSchedules() {
        return ResponseEntity.ok(recurringScheduleService.findAllSchedules());
    }

    @PostMapping("/single")
    public ResponseEntity<SingleScheduleDto> createSingleSchedule(
            @RequestBody SingleScheduleDto dto
            ) {
        return new ResponseEntity<>(singleScheduleService.createSingleSchedule(dto), HttpStatus.CREATED);
    }

    @PostMapping("/recurring")
    public ResponseEntity<RecurringScheduleDto> createRecurringSchedule(
            @RequestBody RecurringScheduleDto dto
    ) {
        return new ResponseEntity<>(recurringScheduleService.createRecurringSchedule(dto), HttpStatus.CREATED);
    }
}
