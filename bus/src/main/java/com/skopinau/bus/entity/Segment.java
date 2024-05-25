package com.skopinau.bus.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "segment")
@JsonIgnoreProperties("segmentSequences")
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "station_from_id", nullable = false)
    private Station stationFrom;

    @ManyToOne
    @JoinColumn(name = "station_to_id", nullable = false)
    private Station stationTo;

    @Column(nullable = false)
    private double distance;

    @OneToMany(mappedBy = "segment", cascade = CascadeType.ALL)
    private List<SegmentSequence> segmentSequences;
}
