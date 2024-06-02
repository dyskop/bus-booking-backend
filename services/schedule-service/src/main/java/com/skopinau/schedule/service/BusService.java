package com.skopinau.schedule.service;

import com.skopinau.schedule.dto.BusDto;
import com.skopinau.schedule.entity.Bus;
import com.skopinau.schedule.exception.AmenityNotExistException;
import com.skopinau.schedule.exception.BusAlreadyExistException;
import com.skopinau.schedule.exception.BusNotExistException;
import com.skopinau.schedule.exception.message.ExceptionMessage;
import com.skopinau.schedule.mapper.BusMapper;
import com.skopinau.schedule.repository.AmenityRepository;
import com.skopinau.schedule.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.skopinau.schedule.exception.message.ExceptionMessage.AMENITY_NOT_EXIST;
import static com.skopinau.schedule.exception.message.ExceptionMessage.INVALID_BUS_NUMBER;

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
