package com.harshitha.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SensorRequest {
	
	@NotBlank(message = "Country name cannot be null or empty string")
	@Pattern(regexp="([a-zA-Z]+\\s)*[a-zA-Z]+",message="Country name cannot have numbers")
	private String country;
	
	@NotBlank(message = "City name cannot be null or empty string")
	@Pattern(regexp="([a-zA-Z]+\\s)*[a-zA-Z]+",message="City name cannot have numbers")
	private String city;

	public SensorRequest() {
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

}
