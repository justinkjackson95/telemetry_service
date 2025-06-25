# Device Telemetry Service

A simple Spring Boot microservice that allows registration of devices and submission of telemetry data.

## Features

- Register new devices
- Submit telemetry data (e.g., signal strength, location)
- Fetch device details and telemetry history

## Stack

- Java 17
- Spring Boot (Web + JPA)
- H2 In-Memory Database
- Maven

## How to Run

1. Open the project in your IDE.
2. Run the `DeviceTelemetryServiceApplication.java` class.
3. Access H2 Console at: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:telemetrydb`
4. Use Postman or curl to interact with endpoints.

## Future Enhancements

- Add unit tests
- Add Docker support
- Use PostgreSQL for persistent storage
