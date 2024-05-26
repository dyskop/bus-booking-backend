package com.skopinau.schedule.client;

import com.skopinau.schedule.client.dto.Bus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bus-service", url = "${application.config.bus-url}")
public interface BusClient {

    @GetMapping("/{id}")
    ResponseEntity<Bus> findBusById(@PathVariable long id);
}
