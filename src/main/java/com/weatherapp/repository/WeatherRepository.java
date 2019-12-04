package com.weatherapp.repository;

import com.weatherapp.dto.WeatherSummary;

/**
 * Interface for the weather summary repository.
 * 
 * @author heranbuddhika
 *
 */
public interface WeatherRepository {

	/**
	 * This method returns a weather summary object which matches the given city
	 * code.
	 * 
	 * @param cityCode
	 * @return returns a <code>WeatherSummary</code> object.
	 */
	public WeatherSummary findWeatherSummary(String cityCode);
}
