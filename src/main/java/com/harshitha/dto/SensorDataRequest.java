package com.harshitha.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//Validation for temperature, Wind and Humidity parameters  

public class SensorDataRequest {

	@NotNull(message = "Temp cannot be null")
	private double temp;
	
	@NotNull(message = "Wind speed cannot be null")
	@Min(value = 0, message = "Wind speed cannot be negative")
	private double wind;
	
	@NotNull(message = "Humidity cannot be null")
	@Min(value = 0, message = "Humidity cannot be negative")
	private double humidity;
	
	public SensorDataRequest() {
		super();
		// TODO Auto-generated constructor stub
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

}
