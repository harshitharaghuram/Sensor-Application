package com.harshitha.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sensor")
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sensor_id")
	private Long sensorId;

	@Column(name = "sensor_country", nullable = false)
	private String country;
	
	@Column(name = "sensor_city", nullable = false)
	private String city;
	
	@OneToMany(targetEntity = SensorData.class, mappedBy = "sensor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = false)
	private List<SensorData> sensorData;

	public Sensor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getSensorId() {
		return sensorId;
	}

	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<SensorData> getSensorData() {
		return sensorData;
	}

	public void setSensorData(List<SensorData> sensorData) {
		this.sensorData = sensorData;
	}
}
