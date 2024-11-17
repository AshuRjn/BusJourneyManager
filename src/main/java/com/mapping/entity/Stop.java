package com.mapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stop")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Auto-generated ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "stopname", nullable = false)
    private String stopname;

    // delete stop id from bus_stop also
    @OneToMany(mappedBy = "stop", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private List<BusStop> busStops;

}