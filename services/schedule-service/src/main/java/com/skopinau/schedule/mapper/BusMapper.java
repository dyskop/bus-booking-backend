package com.skopinau.schedule.mapper;

import com.skopinau.schedule.dto.BusDto;
import com.skopinau.schedule.entity.Bus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusMapper {

    BusDto mapToBusResponse(Bus bus);
    Bus mapToBus(BusDto dto);
}
