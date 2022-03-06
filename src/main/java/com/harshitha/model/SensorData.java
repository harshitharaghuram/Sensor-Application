package com.harshitha.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sensor_data")
public class SensorData {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sensor_data_id")
	private Long sensorDataId;

	@Column(name = "temp", nullable = false)
	private double temp;
	
	@Column(name = "wind", nullable = false)
	private double wind;
	
	@Column(name = "humidity", nullable = false)
	private double humidity;
	
	@Column(name = "received", nullable = false)
	private LocalDateTime receivedDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
	private Sensor sensor;

	public SensorData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getSensorDataId() {
		return sensorDataId;
	}

	public void setSensorDataId(Long sensorDataId) {
		this.sensorDataId = sensorDataId;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getWind() {
		return wind;
	}

	public void setWind(double wind) {
		this.wind = wind;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public LocalDateTime getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDateTime receivedDate) {
		this.receivedDate = receivedDate;
	}
	
}
