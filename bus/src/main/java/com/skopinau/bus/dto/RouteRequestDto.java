package com.skopinau.bus.dto;

import lombok.Builder;

import java.util.LinkedList;
import java.util.Set;

@Builder
public record RouteRequestDto(
        LinkedList<String> stationNames,
        Set<String> busNumbers
) {
}
