package com.harshitha.service.iface;

import java.time.LocalDateTime;

import com.harshitha.dto.SensorDataRequest;

public interface SensorDataService {

	void addSensorData(final SensorDataRequest sensorData, final Long sensorId) throws Exception;

	double avgTemp(Long sensorId, LocalDateTime from, LocalDateTime to) throws Exception;

	double avgHumidity(Long sensorId, LocalDateTime from, LocalDateTime to) throws Exception;

	double avgWind(Long sensorId, LocalDateTime from, LocalDateTime to) throws Exception;
}
