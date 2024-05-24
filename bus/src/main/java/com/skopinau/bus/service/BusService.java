package com.skopinau.bus.service;

import com.skopinau.bus.dto.BusDto;
import com.skopinau.bus.entity.Bus;
import com.skopinau.bus.exception.AmenityNotExistException;
import com.skopinau.bus.mapper.BusMapper;
import com.skopinau.bus.repository.AmenityRepository;
import com.skopinau.bus.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.skopinau.bus.exception.message.ExceptionMessage.AMENITY_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class BusService {

    private final BusRepository busRepository;
    private final AmenityRepository amenityRepository;
    private final BusMapper busMapper;

    public List<BusDto> findAllBuses() {
        return busRepository.findAll().stream()
                .map(busMapper::busToBusResponse)
                .toList();
    }

    @Transactional
    public Bus saveBus(BusDto busDto) {
        // todo: number and capacity validation
        busDto.amenities().forEach(
                amenity -> {
                    String name = amenity.getName();
                    String message = String.format(AMENITY_NOT_EXIST.getMessage(), name);
                    Long id = amenityRepository.findByName(name)
                            .orElseThrow(() -> new AmenityNotExistException(message)).getId();
                    amenity.setId(id);
                }
        );
        return busRepository.save(busMapper.busDtoToBus(busDto));
    }
}
