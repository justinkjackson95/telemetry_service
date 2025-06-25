# 📡 Device Telemetry Service

A lightweight Spring Boot microservice for registering devices and recording their telemetry data (e.g., signal strength, location, timestamps). This service is ideal as a backend component in IoT platforms, asset tracking systems, or telemetry monitoring dashboards.

---

## 🎯 Purpose

This service provides a simple backend API to:
- Register new devices (e.g., IoT sensors, network nodes)
- Submit telemetry data from those devices
- Retrieve device details and telemetry history

It demonstrates clean separation of concerns, RESTful API design, and in-memory persistence using Spring Boot and JPA.

---

## 🧰 Tech Stack

| Technology        | Purpose                                         |
|-------------------|--------------------------------------------------|
| **Java 17**        | Modern language features and compatibility      |
| **Spring Boot**    | Rapid API development using Web + JPA modules   |
| **Spring Data JPA**| Simplifies database interactions via repositories |
| **H2 In-Memory DB**| Lightweight and fast for dev/testing            |
| **Maven**          | Dependency and build management                 |

---

## 📁 Project Structure

src/
├── controller/ # REST endpoints (DeviceController, TelemetryController)
├── model/ # JPA entities (Device, Telemetry)
├── repository/ # Spring Data JPA interfaces
├── service/ # Business logic layer
└── DeviceTelemetryServiceApplication.java # Main Spring Boot entrypoint


---

## 🚀 How to Run

### 1. Clone and Open in Your IDE

bash

git clone https://github.com/yourusername/device-telemetry-service.git
cd device-telemetry-service

2. Run the Spring Boot App
You can run the application directly from your IDE (DeviceTelemetryServiceApplication.java) or via the terminal:

bash
Copy
Edit
./mvnw spring-boot:run
3. Access H2 Console (for debugging)
URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:telemetrydb

Username: sa

Password: (leave blank)

📡 Example API Endpoints
Use Postman, curl, or any HTTP client to interact with the service.

➕ Register a Device

POST /api/devices
Content-Type: application/json

{
  "name": "TempSensor-A12",
  "type": "temperature"
}

📥 Submit Telemetry Data
POST /api/telemetry
Content-Type: application/json

{
  "deviceId": 1,
  "signalStrength": -67,
  "latitude": 38.8951,
  "longitude": -77.0364,
  "timestamp": "2025-06-25T15:30:00"
}

📊 Get Device and Its Telemetry
GET /api/devices/1

🧠 Design Choices
Decision	Rationale
H2 Database	Quick setup and teardown; ideal for demo or test environments
Spring JPA	Eliminates boilerplate CRUD; enables rapid development
Layered Architecture	Separation of concerns via Controller, Service, Repository
UUIDs or Auto IDs	Ensures easy device identification and avoids collisions
ISO Timestamps	Standard format for telemetry ingestion and future analytics

✅ Current Features
Register new devices with name/type

Submit telemetry records per device

Retrieve a device and all of its telemetry history

In-memory database for easy reset between runs

H2 Console for visualizing and debugging data

🔭 Future Enhancements
Feature	Description
✅ Unit tests	Add JUnit + Mockito coverage for services and controllers
⛴️ Dockerization	Containerize the service for easy deployment
💾 Persistent DB	Replace H2 with PostgreSQL or MySQL for production use
🧪 API Testing	Integrate Postman collection or REST-assured tests
🔐 Security	Add API key or OAuth2 for secured telemetry submission
📈 Monitoring	Expose actuator metrics or Prometheus endpoints


🧪 Example Use Case
You have 100 IoT sensors installed in a building. Each sends its location and signal strength every 5 minutes.
This service acts as the backend receiver for those readings and stores them in a retrievable format for dashboards or alerts.

📄 License
This project is open-source and available under the MIT License.
