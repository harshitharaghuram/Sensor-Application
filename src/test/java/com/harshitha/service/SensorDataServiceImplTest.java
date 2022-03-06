package com.harshitha.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.harshitha.model.Sensor;
import com.harshitha.model.SensorData;
import com.harshitha.repo.SensorDataRepository;
import com.harshitha.repo.SensorRepository;
import com.harshitha.service.impl.SensorDataServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SensorDataServiceImplTest {

	@InjectMocks
	SensorDataServiceImpl service;

	@Mock
	SensorRepository repo;

	@Mock
	SensorDataRepository dRepo;

	@Test
	public void testAvgTemp() throws Exception {
		List<SensorData> sensorDataInfo = new ArrayList<>();
		SensorData sensorData = new SensorData(); sensorData.setTemp(2.0); 
		sensorData.setReceivedDate(LocalDateTime.now());
		sensorDataInfo.add(sensorData);
		Sensor sensor = new Sensor();
		sensor.setSensorData(sensorDataInfo);
		when(repo.findBySensorId(ArgumentMatchers.any())).thenReturn(Optional.of(sensor));

		assertThat(service.avgTemp(1L, null, null)).isEqualTo(2.0);
	}
}