package com.harshitha.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harshitha.dto.SensorDataRequest;
import com.harshitha.service.iface.SensorDataService;

@RestController
public class SensorDataController {

	@Autowired
	private SensorDataService sensorDataService;

	@PostMapping("{id}/metric")
	public ResponseEntity<Void> addMetric(
			@PathVariable("id") final Long sensorId,
			@Valid @RequestBody final SensorDataRequest sensorData) throws Exception {
		sensorDataService.addSensorData(sensorData, sensorId);
		return ResponseEntity.ok().build();
	}

	@GetMapping("{id}/metric/temp")
	private ResponseEntity<Map<String, Double>> avgTemp(@PathVariable("id") final Long sensorId, 
			@RequestParam("from") LocalDateTime from, @RequestParam("to") LocalDateTime to) throws Exception{
		Map<String, Double> response = new HashMap<>();
		response.put("avgTemp", sensorDataService.avgTemp(sensorId, from, to));
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}/metric/humidity")
	private ResponseEntity<Map<String, Double>> avgHumidity(@PathVariable("id") final Long sensorId,
			@RequestParam("from") LocalDateTime from, @RequestParam("to") LocalDateTime to) throws Exception{
		Map<String, Double> response = new HashMap<>();
		response.put("avgHumidity", sensorDataService.avgHumidity(sensorId, from, to));
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}/metric/wind")
	private ResponseEntity<Map<String, Double>> avgWind(@PathVariable("id") final Long sensorId,
			@RequestParam("from") LocalDateTime from, @RequestParam("to") LocalDateTime to) throws Exception{
		Map<String, Double> response = new HashMap<>();
		response.put("avgWind", sensorDataService.avgWind(sensorId, from, to));
		return ResponseEntity.ok(response);
	}


}
