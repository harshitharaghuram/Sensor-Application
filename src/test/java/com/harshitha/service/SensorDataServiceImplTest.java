package com.harshitha.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
	
// Test Case to compute Average Temperature 
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
	@Test
	public void testAvgTemp1() throws Exception {
		List<SensorData> sensorDataInfo = new ArrayList<>();
		SensorData sensorData = new SensorData(); sensorData.setTemp(2.0); 
		sensorData.setReceivedDate(LocalDateTime.now());
		sensorDataInfo.add(sensorData);
		Sensor sensor = new Sensor();
		sensor.setSensorData(sensorDataInfo);
		
		when(repo.findBySensorId(ArgumentMatchers.any())).thenReturn(Optional.of(sensor));

		assertThat(service.avgTemp(1L, LocalDateTime.now(), null)).isEqualTo(2.0);
	}
	@Test
	public void testAvgTemp2() throws Exception {
		List<SensorData> sensorDataInfo = new ArrayList<>();
		SensorData sensorData = new SensorData(); sensorData.setTemp(2.0); 
		sensorData.setReceivedDate(LocalDateTime.now());
		sensorDataInfo.add(sensorData);
		Sensor sensor = new Sensor();
		sensor.setSensorData(sensorDataInfo);
		when(repo.findBySensorId(ArgumentMatchers.any())).thenReturn(Optional.of(sensor));

		assertThat(service.avgTemp(1L, LocalDateTime.now().minusDays(1), LocalDateTime.now())).isEqualTo(2.0);
	}	
	
// Test Case to compute Average Humidity
	@Test
	public void testAvgHumidity() throws Exception {
		List<SensorData> sensorDataInfo = new ArrayList<>();
		SensorData sensorData = new SensorData(); sensorData.setTemp(2.0); 
		sensorData.setReceivedDate(LocalDateTime.now());
		sensorDataInfo.add(sensorData);
		Sensor sensor = new Sensor();
		sensor.setSensorData(sensorDataInfo);
		when(repo.findBySensorId(ArgumentMatchers.any())).thenReturn(Optional.of(sensor));

		assertThat(service.avgTemp(1L, null, null)).isEqualTo(2.0);
	}
	
	@Test
	public void testAvgHumidity1() throws Exception {
		List<SensorData> sensorDataInfo = new ArrayList<>();
		SensorData sensorData = new SensorData(); sensorData.setTemp(2.0); 
		sensorData.setReceivedDate(LocalDateTime.now());
		sensorDataInfo.add(sensorData);
		Sensor sensor = new Sensor();
		sensor.setSensorData(sensorDataInfo);
		
		when(repo.findBySensorId(ArgumentMatchers.any())).thenReturn(Optional.of(sensor));

		assertThat(service.avgTemp(1L, LocalDateTime.now(), null)).isEqualTo(2.0);
	}
	
	@Test
	public void testAvgHumidity2() throws Exception {
		List<SensorData> sensorDataInfo = new ArrayList<>();
		SensorData sensorData = new SensorData(); sensorData.setTemp(2.0); 
		sensorData.setReceivedDate(LocalDateTime.now());
		sensorDataInfo.add(sensorData);
		Sensor sensor = new Sensor();
		sensor.setSensorData(sensorDataInfo);
		when(repo.findBySensorId(ArgumentMatchers.any())).thenReturn(Optional.of(sensor));

		assertThat(service.avgTemp(1L, LocalDateTime.now().minusDays(1), LocalDateTime.now())).isEqualTo(2.0);
	}	
	
// Test Case to compute Average Wind	
	@Test
	public void testAvgWind() throws Exception {
		List<SensorData> sensorDataInfo = new ArrayList<>();
		SensorData sensorData = new SensorData(); sensorData.setTemp(2.0); 
		sensorData.setReceivedDate(LocalDateTime.now());
		sensorDataInfo.add(sensorData);
		Sensor sensor = new Sensor();
		sensor.setSensorData(sensorDataInfo);
		when(repo.findBySensorId(ArgumentMatchers.any())).thenReturn(Optional.of(sensor));

		assertThat(service.avgTemp(1L, null, null)).isEqualTo(2.0);
	}
	
	
	@Test
	public void testAvgWind1() throws Exception {
		List<SensorData> sensorDataInfo = new ArrayList<>();
		SensorData sensorData = new SensorData(); sensorData.setTemp(2.0); 
		sensorData.setReceivedDate(LocalDateTime.now());
		sensorDataInfo.add(sensorData);
		Sensor sensor = new Sensor();
		sensor.setSensorData(sensorDataInfo);
		
		when(repo.findBySensorId(ArgumentMatchers.any())).thenReturn(Optional.of(sensor));

		assertThat(service.avgTemp(1L, LocalDateTime.now(), null)).isEqualTo(2.0);
	}
	
	@Test
	public void testAvgWind2() throws Exception {
		List<SensorData> sensorDataInfo = new ArrayList<>();
		SensorData sensorData = new SensorData(); sensorData.setTemp(2.0); 
		sensorData.setReceivedDate(LocalDateTime.now());
		sensorDataInfo.add(sensorData);
		Sensor sensor = new Sensor();
		sensor.setSensorData(sensorDataInfo);
		when(repo.findBySensorId(ArgumentMatchers.any())).thenReturn(Optional.of(sensor));

		assertThat(service.avgTemp(1L, LocalDateTime.now().minusDays(1), LocalDateTime.now())).isEqualTo(2.0);
	}	
	
	
	
}
