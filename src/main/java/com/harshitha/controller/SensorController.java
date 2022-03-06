package com.harshitha.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harshitha.dto.SensorRequest;
import com.harshitha.model.Sensor;
import com.harshitha.service.iface.SensorService;

@RestController
public class SensorController {

	@Autowired
	private SensorService sensorService;

	@PostMapping(value = "/")
	public ResponseEntity<Map<String, Long>> createSensor(@Valid @RequestBody final SensorRequest sensorRequest) {
		final Sensor sensorInfo = sensorService.createSensor(sensorRequest);
		Map<String, Long> response = new HashMap<>();
		response.put("sensorId", sensorInfo.getSensorId());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Sensor>> listSensors(){
		return ResponseEntity.ok(sensorService.listSensors());
	}
}
