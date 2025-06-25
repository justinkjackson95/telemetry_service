package com.example.telemetry.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Telemetry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double signalStrength;
    private LocalDateTime timestamp;
    private double latitude;
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "device_id")
    @JsonBackReference
    private Device device;
}
