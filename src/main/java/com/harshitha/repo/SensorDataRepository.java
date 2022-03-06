package com.harshitha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshitha.model.SensorData;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

}
