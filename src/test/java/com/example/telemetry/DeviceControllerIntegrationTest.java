package com.example.telemetry;

import com.example.telemetry.model.Device;
import com.example.telemetry.repository.DeviceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = DeviceTelemetryServiceApplication.class)
class DeviceControllerIntegrationTest {

    @Autowired
    private DeviceRepository deviceRepository;

    @Test
    void testRegisterDevice() {
        Device device = new Device();
        device.setName("Test Radar");
        device.setLocation("Test Location");
        device.setStatus("active");

        Device saved = deviceRepository.save(device);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("Test Radar");
    }
}
