package com.example.telemetry.controller;

import com.example.telemetry.model.Device;
import com.example.telemetry.model.Telemetry;
import com.example.telemetry.repository.DeviceRepository;
import com.example.telemetry.repository.TelemetryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private TelemetryRepository telemetryRepository;

    @PostMapping
    public Device registerDevice(@RequestBody Device device) {
        return deviceRepository.save(device);
    }

    @PostMapping("/{id}/telemetry")
    public Telemetry addTelemetry(@PathVariable Long id, @RequestBody Telemetry telemetry) {
        Optional<Device> deviceOpt = deviceRepository.findById(id);
        if (deviceOpt.isPresent()) {
            telemetry.setDevice(deviceOpt.get());
            return telemetryRepository.save(telemetry);
        } else {
            throw new RuntimeException("Device not found with ID: " + id);
        }
    }

    @GetMapping("/{id}")
    public Device getDevice(@PathVariable Long id) {
        return deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @GetMapping("/{id}/telemetry")
    public List<Telemetry> getTelemetry(@PathVariable Long id) {
        return telemetryRepository.findByDeviceId(id);
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody Map<String, Object> body) {
        System.out.println("Received: " + body);
        return ResponseEntity.ok("It worked");
    }

}
