package com.smartcampus.store;

import com.smartcampus.model.Room;
import com.smartcampus.model.Sensor;
import com.smartcampus.model.SensorReading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {
    public static final Map<String, Room> rooms = new HashMap<>();
    public static final Map<String, Sensor> sensors = new HashMap<>();
    public static final Map<String, List<SensorReading>> readings = new HashMap<>();

    static {
        rooms.put("LIB-301", new Room("LIB-301", "Library Quiet Study", 40));
        rooms.put("LAB-101", new Room("LAB-101", "Computer Lab 1", 30));
    }

    private DataStore() {
    }
}