package com.skopinau.bus.booking.mapper;

import com.skopinau.bus.booking.dto.BusRequest;
import com.skopinau.bus.booking.dto.BusResponse;
import com.skopinau.bus.booking.entity.Bus;
import com.skopinau.bus.booking.service.AmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BusMapper {

    private final AmenityService amenityService;
    private final AmenityMapper amenityMapper;

    public Bus toBus(BusRequest request) {
        if (request == null) {
            return null;
        }
        return Bus.builder()
                .id(request.id())
                .registrationNumber(request.registrationNumber())
                .model(request.model())
                .capacity(request.capacity())
                .amenities(
                        request.amenities()
                                .stream()
                                .map(amenityService::findByName)
                                .collect(Collectors.toList())
                )
                .build();
    }

    public BusResponse toBusResponse(Bus bus) {
        if (bus == null) {
            return null;
        }
        return BusResponse.builder()
                .id(bus.getId())
                .registrationNumber(bus.getRegistrationNumber())
                .model(bus.getModel())
                .capacity(bus.getCapacity())
                .amenities(
                        bus.getAmenities()
                                .stream()
                                .map(amenityMapper::toAmenityResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
