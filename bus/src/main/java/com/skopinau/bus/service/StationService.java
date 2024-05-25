package com.skopinau.bus.service;

import com.skopinau.bus.entity.Station;
import com.skopinau.bus.exception.StationNotExistException;
import com.skopinau.bus.exception.message.ExceptionMessage;
import com.skopinau.bus.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;

    public Station findStationByName(String name) {
        String message = String.format(ExceptionMessage.STATION_NOT_EXIST.getMessage(), name);
        return stationRepository.findByName(name)
                .orElseThrow(() -> new StationNotExistException(message));
    }
}
