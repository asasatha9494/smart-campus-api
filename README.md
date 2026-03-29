# Smart Campus Sensor & Room Management API

Coursework module: 5COSC022W Client-Server Architectures


## Overview
This project is a RESTful API developed using JAX-RS for the Smart Campus coursework. The API manages rooms, sensors assigned to rooms, and historical sensor readings. It demonstrates RESTful design, nested resources, custom exception mapping, and request/response logging. The API is designed for the Smart Campus Sensor & Room Management scenario.

The system models three main resources:
- **Room**: stores room details such as id, name, capacity, and assigned sensor IDs
- **Sensor**: stores sensor details such as id, type, status, currentValue, and the room it belongs to
- **SensorReading**: stores historical reading data such as id, timestamp, and value

This implementation uses in-memory data structures such as **HashMap** and **ArrayList**, as required by the coursework.

## Technology Used
- Java
- JAX-RS (Jersey)
- Grizzly HTTP Server
- Maven
- HashMap
- ArrayList
- JSON

## API Base URL
```text
http://localhost:8080/api/v1/
```
## Main Features
- Discovery endpoint for API metadata
- Room creation, retrieval, and deletion
- Sensor creation and retrieval
- Sensor filtering by type using query parameters
- Nested sensor reading history using a sub-resource locator
- Automatic update of sensor currentValue when a new reading is added
- Custom exception handling for important business rules
- Structured JSON responses for successful and failed requests
- Request and response logging using JAX-RS filters


## Project Structure 
- Main.java
- config/ApplicationConfig.java
- model/Room.java
- model/Sensor.java
- model/SensorReading.java
- store/DataStore.java
- resource/DiscoveryResource.java
- resource/RoomResource.java
- resource/SensorResource.java
- resource/SensorReadingResource.java
- exception/RoomNotEmptyException.java
- exception/LinkedResourceNotFoundException.java
- exception/SensorUnavailableException.java
- mapper/RoomNotEmptyExceptionMapper.java
- mapper/LinkedResourceNotFoundExceptionMapper.java
- mapper/SensorUnavailableExceptionMapper.java
- mapper/GlobalExceptionMapper.java
- filter/LoggingFilter.java


## How to Build and Run 

## Prerequisites
- Java JDK 17 or above
- Maven
- Git
- IntelliJ IDEA or another Java IDE

Step 1: Clone the repository
git clone https://github.com/asasatha9494/smart-campus-api.git
Step 2: Move into the project folder
cd smart-campus-api
Step 3: Compile the project
mvn clean compile
Step 4: Run the application
mvn exec:java
Step 5: Access the API

Open in browser, Postman, or curl:

http://localhost:8080/api/v1/
API Endpoints
Discovery
GET /api/v1
Rooms
GET /api/v1/rooms
POST /api/v1/rooms
GET /api/v1/rooms/{roomId}
DELETE /api/v1/rooms/{roomId}
Sensors
POST /api/v1/sensors
GET /api/v1/sensors
GET /api/v1/sensors?type=Temperature
Sensor Readings
GET /api/v1/sensors/{sensorId}/readings
POST /api/v1/sensors/{sensorId}/readings
Sample curl Commands
1. Get discovery information
   curl http://localhost:8080/api/v1/
2. Get all rooms
   curl http://localhost:8080/api/v1/rooms
3. Get a room by ID
   curl http://localhost:8080/api/v1/rooms/LIB-301
4. Create a new room
   curl -X POST http://localhost:8080/api/v1/rooms -H "Content-Type: application/json" -d "{\"id\":\"ENG-201\",\"name\":\"Engineering Room\",\"capacity\":50}"
5. Create a new sensor
   curl -X POST http://localhost:8080/api/v1/sensors -H "Content-Type: application/json" -d "{\"id\":\"TEMP-001\",\"type\":\"Temperature\",\"status\":\"ACTIVE\",\"currentValue\":25.5,\"roomId\":\"LIB-301\"}"
6. Filter sensors by type
   curl "http://localhost:8080/api/v1/sensors?type=Temperature"
7. Add a sensor reading
   curl -X POST http://localhost:8080/api/v1/sensors/TEMP-001/readings -H "Content-Type: application/json" -d "{\"id\":\"READ-001\",\"timestamp\":1710000000,\"value\":28.7}"
8. Get sensor readings
   curl http://localhost:8080/api/v1/sensors/TEMP-001/readings
9. Delete a room
   curl -X DELETE http://localhost:8080/api/v1/rooms/LAB-101
   Error Handling

The API includes custom exception mapping to return meaningful JSON responses instead of raw server errors.

Implemented cases:

409 Conflict when attempting to delete a room that still has assigned sensors
422 Unprocessable Entity when creating a sensor with a non-existent room reference
403 Forbidden when attempting to add a reading to a sensor in MAINTENANCE state
500 Internal Server Error for unexpected runtime failures

All custom exceptions return JSON responses with an error title and message.

Logging

A custom logging filter is implemented using:

ContainerRequestFilter
ContainerResponseFilter
java.util.logging.Logger

It logs:

incoming HTTP method and request URI
outgoing HTTP response status code
Notes
This project uses in-memory storage only
Data resets whenever the server restarts
All data is stored temporarily during runtime
No external database is used
The implementation uses JAX-RS only
This project was developed as part of the Smart Campus coursework scenario

Then save it with `Ctrl + S`.

For your next commit, use:

```bash
git add README.md
git commit -m "Clean and finalize README structure"
git push