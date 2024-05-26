package com.skopinau.schedule.controller;

import com.skopinau.schedule.dto.SingleScheduleRequestDto;
import com.skopinau.schedule.entity.RecurringSchedule;
import com.skopinau.schedule.entity.Schedule;
import com.skopinau.schedule.entity.SingleSchedule;
import com.skopinau.schedule.service.RecurringScheduleService;
import com.skopinau.schedule.service.ScheduleService;
import com.skopinau.schedule.service.SingleScheduleService;
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
    public ResponseEntity<SingleSchedule> createSingleSchedule(
            @RequestBody SingleScheduleRequestDto dto
            ) {
        return new ResponseEntity<>(singleScheduleService.createSingleSchedule(dto), HttpStatus.CREATED);
    }

}
