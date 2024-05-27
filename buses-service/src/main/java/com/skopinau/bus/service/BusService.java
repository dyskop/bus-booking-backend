package com.skopinau.bus.service;

import com.skopinau.bus.dto.BusDto;
import com.skopinau.bus.entity.Bus;
import com.skopinau.bus.exception.AmenityNotExistException;
import com.skopinau.bus.exception.BusAlreadyExistException;
import com.skopinau.bus.exception.BusNotExistException;
import com.skopinau.bus.exception.message.ExceptionMessage;
import com.skopinau.bus.mapper.BusMapper;
import com.skopinau.bus.repository.AmenityRepository;
import com.skopinau.bus.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.skopinau.bus.exception.message.ExceptionMessage.AMENITY_NOT_EXIST;
import static com.skopinau.bus.exception.message.ExceptionMessage.INVALID_BUS_NUMBER;

@Service
@RequiredArgsConstructor
public class BusService {

    private final BusRepository busRepository;
    private final AmenityRepository amenityRepository;
    private final BusMapper busMapper;

    public List<BusDto> findAllBuses() {
        return busRepository.findAll().stream()
                .map(busMapper::mapToBusResponse)
                .toList();
    }

    @Transactional
    public BusDto saveBus(BusDto busDto) {
        checkBusNumber(busDto.number());
        busDto.amenities().forEach(
                amenity -> {
                    String name = amenity.getName();
                    Long id = amenityRepository.findByName(name)
                            .orElseThrow(() -> {
                                String message = String.format(AMENITY_NOT_EXIST.getMessage(), name);
                                throw new AmenityNotExistException(message);
                            })
                            .getId();
                    amenity.setId(id);
                }
        );
        Bus bus = busRepository.save(busMapper.mapToBus(busDto));
        return busMapper.mapToBusResponse(bus);
    }

    public BusDto findBusDtoById(long id) {
        Bus bus = findBusById(id);
        return busMapper.mapToBusResponse(bus);
    }

    public Bus findBusById(long id) {
        Optional<Bus> busOptional = busRepository.findById(id);
        return busOptional.orElseThrow(() -> {
            String message = String.format(ExceptionMessage.INVALID_BUS_ID.getMessage(), id);
            throw new BusNotExistException(message);
        });
    }

    private void checkBusNumber(String number) {
        Optional<Bus> busOptional = busRepository.findByNumber(number);
        busOptional.ifPresent(bus -> {
            String message = String.format(INVALID_BUS_NUMBER.getMessage(), number);
            throw new BusAlreadyExistException(message);
        });
    }
}
