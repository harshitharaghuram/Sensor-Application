package com.harshitha.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshitha.dto.SensorDataRequest;
import com.harshitha.model.Sensor;
import com.harshitha.model.SensorData;
import com.harshitha.repo.SensorDataRepository;
import com.harshitha.repo.SensorRepository;
import com.harshitha.service.iface.SensorDataService;

@Service
public class SensorDataServiceImpl implements SensorDataService {

	@Autowired
	private SensorRepository sensorRepo;

	@Autowired
	private SensorDataRepository sensorDataRepo;

	@Override
	public void addSensorData(final SensorDataRequest sensorData, final Long sensorId) throws Exception {
		//Using primary key to retrieve the data
		
		Sensor requestedSensor = sensorRepo.findBySensorId(sensorId).orElseThrow(Exception::new);
		//Object created to store the retrieved data
		
		SensorData sensorDataInfo = new SensorData();
		BeanUtils.copyProperties(sensorData, sensorDataInfo);
		
		//Retrieving data for current time from the sensors
		sensorDataInfo.setReceivedDate(LocalDateTime.now());
		sensorDataInfo.setSensor(requestedSensor);

		sensorDataRepo.save(sensorDataInfo);
	}
	
	//Retrieving temperature data from a sensor for a particular time period
	
	@Override
	public double avgTemp(Long sensorId, LocalDateTime from, LocalDateTime to) throws Exception {
		Sensor requestedSensor = sensorRepo.findBySensorId(sensorId).orElseThrow(Exception::new);

		Stream<SensorData> stream = requestedSensor.getSensorData().stream();
		if(from == null && to == null) {
			stream = stream.filter(s->s.getReceivedDate().toLocalDate().isEqual(LocalDate.now()));
		}
		else if(from != null && to != null) {
			stream = stream.filter(s->s.getReceivedDate().toLocalDate().isAfter(from.toLocalDate().minusDays(1)) && 
					s.getReceivedDate().toLocalDate().isBefore(to.toLocalDate().plusDays(1)));	
		}
		return stream.mapToDouble(SensorData::getTemp).average().getAsDouble();
	}
	
	//Retrieving humidity data from a sensor for particular a time period	

	@Override
	public double avgHumidity(Long sensorId, LocalDateTime from, LocalDateTime to) throws Exception  {
		Sensor requestedSensor = sensorRepo.findBySensorId(sensorId).orElseThrow(Exception::new);

		Stream<SensorData> stream = requestedSensor.getSensorData().stream();
		if(from == null && to == null) {
			stream = stream.filter(s->s.getReceivedDate().toLocalDate().isEqual(LocalDate.now()));
		}
		else if(from != null && to != null) {
			stream = stream.filter(s->s.getReceivedDate().toLocalDate().isAfter(from.toLocalDate()) && 
					s.getReceivedDate().toLocalDate().isBefore(to.toLocalDate()));
		}
		return stream.mapToDouble(SensorData::getHumidity).average().getAsDouble();
	}
	
	//Retrieving Wind data from a sensor for a particular time period

	@Override
	public double avgWind(Long sensorId, LocalDateTime from, LocalDateTime to) throws Exception {
		Sensor requestedSensor = sensorRepo.findBySensorId(sensorId).orElseThrow(Exception::new);

		Stream<SensorData> stream = requestedSensor.getSensorData().stream();
		if(from == null && to == null) {
			stream = stream.filter(s->s.getReceivedDate().toLocalDate().isEqual(LocalDate.now()));
		}
		else if(from != null && to != null) {
			stream = stream.filter(s->s.getReceivedDate().toLocalDate().isAfter(from.toLocalDate()) && 
					s.getReceivedDate().toLocalDate().isBefore(to.toLocalDate()));
		}
		return stream.mapToDouble(SensorData::getWind).average().getAsDouble();
	}
	
	

}

