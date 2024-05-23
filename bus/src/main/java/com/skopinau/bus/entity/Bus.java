package com.skopinau.bus.entity;

import com.skopinau.bus.model.Amenity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bus {

    @Id
    @GeneratedValue
    private Integer id;
    private String number;
    private String model;
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    private List<Amenity> amenities;
}
