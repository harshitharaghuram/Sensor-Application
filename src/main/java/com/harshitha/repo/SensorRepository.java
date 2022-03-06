package com.harshitha.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshitha.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
	Optional<Sensor> findBySensorId(final Long sensorId);
}
