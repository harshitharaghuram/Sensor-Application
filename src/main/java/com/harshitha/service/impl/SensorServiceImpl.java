
package com.harshitha.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshitha.dto.SensorRequest;
import com.harshitha.model.Sensor;
import com.harshitha.repo.SensorRepository;
import com.harshitha.service.iface.SensorService;

@Service
public class SensorServiceImpl implements SensorService{
	
	@Autowired
	private SensorRepository sensorRepo;

	
	@Override
	public Sensor createSensor(SensorRequest sensorRequest) {
		final Sensor sensorInfo = new Sensor();
		//The data is transferred from  sensorRequest to sensorInfo and is saved in the PostGRE SQL
		
		BeanUtils.copyProperties(sensorRequest, sensorInfo);
		//The object obtained in the save function is passed to the controller
		return sensorRepo.save(sensorInfo);
	}

	@Override
	public List<Sensor> listSensors() {
		return sensorRepo.findAll();
	}
}
