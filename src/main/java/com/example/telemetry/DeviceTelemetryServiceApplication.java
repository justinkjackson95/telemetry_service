package com.example.telemetry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.telemetry")
public class DeviceTelemetryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeviceTelemetryServiceApplication.class, args);
    }
}
