package com.example.telemetry.repository;

import com.example.telemetry.model.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {
    List<Telemetry> findByDeviceId(Long deviceId);
}
