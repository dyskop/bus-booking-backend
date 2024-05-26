package com.skopinau.schedule.client.dto;

import lombok.*;

@Builder
public record Bus(
        long id,
        String number
) {
}
