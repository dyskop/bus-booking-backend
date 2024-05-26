package com.skopinau.bus.service;

import com.skopinau.bus.dto.StationDto;
import com.skopinau.bus.entity.Station;
import com.skopinau.bus.exception.StationAlreadyExistException;
import com.skopinau.bus.exception.StationNotExistException;
import com.skopinau.bus.mapper.StationMapper;
import com.skopinau.bus.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.skopinau.bus.exception.message.ExceptionMessage.STATION_ALREADY_EXIST;
import static com.skopinau.bus.exception.message.ExceptionMessage.STATION_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;
    private final StationMapper stationMapper;

    public List<StationDto> findAllStations() {
        return stationRepository.findAll().stream()
                .map(stationMapper::mapToStationDto)
                .toList();
    }

    @Transactional
    public StationDto createStation(StationDto stationDto) {
        stationRepository.findByName(stationDto.name()).ifPresent(station -> {
            String message = String.format(STATION_ALREADY_EXIST.getMessage(), stationDto.name());
            throw new StationAlreadyExistException(message);
        });

        Station station = Station.builder()
                .name(stationDto.name())
                .build();
        return stationMapper.mapToStationDto(stationRepository.save(station));
    }

    public Station findStationByName(String name) {
        return stationRepository.findByName(name)
                .orElseThrow(() -> {
                    String message = String.format(STATION_NOT_EXIST.getMessage(), name);
                    throw new StationNotExistException(message);
                });
    }
}
