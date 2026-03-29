# Smart Campus Sensor & Room Management API
Coursework module: 5COSC022W Client-Server Architectures
## Overview
This project is a RESTful API developed using JAX-RS for the Smart Campus coursework. The API manages rooms, sensors assigned to rooms, and historical sensor readings. It demonstrates RESTful design, nested resources, custom exception mapping, and request/response logging.

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

## API Base URL
```text
http://localhost:8080/api/v1/

## How to Build and Run

### Prerequisites
- Java JDK 17 or above
- Maven
- Git
- IntelliJ IDEA or another Java IDE

### Step 1: Clone the repository
```bash
git clone https://github.com/asasatha9494/smart-campus-api.git