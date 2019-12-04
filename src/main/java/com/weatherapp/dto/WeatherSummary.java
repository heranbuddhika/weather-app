package com.weatherapp.dto;

/**
 * Weather Summary DTO.
 * 
 * @author heranbuddhika
 *
 */
public class WeatherSummary {

	private String city;

	private String cityCode;

	private double temperature;

	public WeatherSummary() {
		super();
	}

	public WeatherSummary(String city, String cityCode, double temperature) {
		super();
		this.city = city;
		this.cityCode = cityCode;
		this.temperature = temperature;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getFahrenheitTemperature() {
		double fahrenheitTemp = (this.temperature * 1.8) - 459.67;
		return String.format("%4.2f", fahrenheitTemp);
	}

	public String getCelsiusTemperature() {
		double celsiusTemp = this.temperature - 273.15;
		return String.format("%4.2f", celsiusTemp);
	}
}
