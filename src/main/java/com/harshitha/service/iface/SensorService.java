package com.harshitha.service.iface;

import java.util.List;

import com.harshitha.dto.SensorRequest;
import com.harshitha.model.Sensor;

public interface SensorService {

	Sensor createSensor(final SensorRequest sensorRequest);

	List<Sensor> listSensors();
}
