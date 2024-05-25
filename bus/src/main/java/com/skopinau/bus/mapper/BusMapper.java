package com.skopinau.bus.mapper;

import com.skopinau.bus.dto.BusDto;
import com.skopinau.bus.entity.Bus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusMapper {

    BusDto mapToBusResponse(Bus bus);
    Bus mapDtoToBus(BusDto dto);
}
