package com.skopinau.schedule.service;

import com.skopinau.schedule.dto.StationDto;
import com.skopinau.schedule.entity.Station;
import com.skopinau.schedule.exception.StationAlreadyExistException;
import com.skopinau.schedule.exception.StationNotExistException;
import com.skopinau.schedule.mapper.StationMapper;
import com.skopinau.schedule.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.skopinau.schedule.exception.message.ExceptionMessage.STATION_ALREADY_EXIST;
import static com.skopinau.schedule.exception.message.ExceptionMessage.STATION_NOT_EXIST;

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
