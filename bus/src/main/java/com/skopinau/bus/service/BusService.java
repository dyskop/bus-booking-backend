package com.skopinau.bus.service;

import com.skopinau.bus.dto.BusDto;
import com.skopinau.bus.mapper.BusMapper;
import com.skopinau.bus.model.entity.Bus;
import com.skopinau.bus.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusService {

    private final BusRepository busRepository;
    private final BusMapper busMapper;

    public List<BusDto> findAllBuses() {
        return busRepository.findAll().stream()
                .map(busMapper::busToBusResponse)
                .toList();
    }

    public Bus saveBus(BusDto busDto) {
        return busRepository.save(busMapper.busDtoToBus(busDto));
    }
}
