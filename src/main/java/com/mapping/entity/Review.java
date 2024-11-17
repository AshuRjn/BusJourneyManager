package com.mapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Auto-generated ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "rating", nullable = false)
    @Schema(description = "Rating for the bus", example = "4.5")
    private Double rating;

    @Column(name = "comment", length = 500)
    @Schema(description = "User's comment about the bus", example = "Very comfortable and clean.")
    private String comment;

    @Column(name = "review_date", nullable = false)
    @Schema(description = "Date when the review was written", example = "2024-11-08")
    private LocalDate reviewDate = LocalDate.now();  // Set current date as default

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id", nullable = false)
    @JsonIgnore
    @Schema(hidden = true)
    private Bus bus;

    @JsonProperty("busId")
    public Long getBusId() {
        return bus != null ? bus.getId() : null;
    }

}


