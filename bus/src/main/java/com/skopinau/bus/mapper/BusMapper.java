package com.skopinau.bus.mapper;

import com.skopinau.bus.dto.BusDto;
import com.skopinau.bus.model.entity.Bus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusMapper {

    BusDto busToBusResponse(Bus bus);
    Bus busDtoToBus(BusDto dto);
}
