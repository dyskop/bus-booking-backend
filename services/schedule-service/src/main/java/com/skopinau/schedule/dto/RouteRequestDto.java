package com.skopinau.schedule.dto;

import lombok.Builder;

import java.util.LinkedList;

@Builder
public record RouteRequestDto(
        LinkedList<String> stationNames
) {
}
