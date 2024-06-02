package com.skopinau.bus.booking.service;

import com.skopinau.bus.booking.dto.BusRequest;
import com.skopinau.bus.booking.dto.BusResponse;
import com.skopinau.bus.booking.entity.Amenity;
import com.skopinau.bus.booking.entity.Bus;
import com.skopinau.bus.booking.exception.BusAlreadyExistsException;
import com.skopinau.bus.booking.exception.BusNotFoundException;
import com.skopinau.bus.booking.mapper.BusMapper;
import com.skopinau.bus.booking.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.skopinau.bus.booking.exception.message.ExceptionMessage.BUS_ALREADY_EXISTS;
import static com.skopinau.bus.booking.exception.message.ExceptionMessage.BUS_NOT_FOUND;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class BusService {

    private final BusRepository busRepository;
    private final BusMapper busMapper;
    private final AmenityService amenityService;

    public Long create(BusRequest request) {
        busRepository.findByRegistrationNumber(request.registrationNumber()).ifPresent(
                bus -> {
                    String message = format(BUS_ALREADY_EXISTS.getMessage(), request.registrationNumber());
                    throw new BusAlreadyExistsException(message);
                }
        );
        Bus bus = busMapper.toBus(request);
        bus = busRepository.save(bus);
        return bus.getId();
    }

    public void update(BusRequest request) {
        Bus bus = busRepository.findById(request.id()).orElseThrow(() -> {
            String message = format(BUS_NOT_FOUND.getMessage(), request.id());
            throw new BusNotFoundException(message);
        });
        mergeBus(bus, request);
        busRepository.save(bus);
    }

    public List<BusResponse> findAll() {
        return busRepository.findAll()
                .stream()
                .map(busMapper::toBusResponse)
                .collect(Collectors.toList());
    }

    public BusResponse findById(long id) {
        return busRepository.findById(id)
                .map(busMapper::toBusResponse)
                .orElseThrow(() -> {
                    String message = format(BUS_NOT_FOUND.getMessage(), id);
                    throw new BusNotFoundException(message);
                });
    }

    public boolean existsById(long id) {
        return busRepository.existsById(id);
    }

    public void deleteById(long id) {
        busRepository.deleteById(id);
    }

    private void mergeBus(Bus bus, BusRequest request) {
        if (StringUtils.isNotBlank(request.registrationNumber())) {
            bus.setRegistrationNumber(request.registrationNumber());
        }
        if (StringUtils.isNotBlank(request.model())) {
            bus.setModel(request.model());
        }
        if (request.capacity() != 0) {
            bus.setCapacity(request.capacity());
        }
        if (request.amenities() != null) {
            List<Amenity> amenities = request.amenities().stream()
                    .map(amenityService::findByName)
                    .collect(Collectors.toList());
            bus.setAmenities(amenities);
        }
    }
}
