package com.harshitha.service.iface;

import java.time.LocalDateTime;

import com.harshitha.dto.SensorDataRequest;
import com.harshitha.exception.RecordNotFoundException;

public interface SensorDataService {

	void addSensorData(final SensorDataRequest sensorData, final Long sensorId) throws RecordNotFoundException;

	double avgTemp(Long sensorId, LocalDateTime from, LocalDateTime to) throws RecordNotFoundException;

	double avgHumidity(Long sensorId, LocalDateTime from, LocalDateTime to) throws RecordNotFoundException;

	double avgWind(Long sensorId, LocalDateTime from, LocalDateTime to) throws RecordNotFoundException;
}
