package com.hireright.weatherapp.repository;

import java.util.ArrayList;
import java.util.List;

import com.hireright.weatherapp.dto.WeatherSummary;

/**
 * Implementation class for the <code>WeatherRepository</code>.
 * 
 * @author heranbuddhika
 *
 */
public class WeatherRepositoryImpl implements WeatherRepository {

	/** Holds a list of <code>WeatherSummary</code> objects. */
	static List<WeatherSummary> weatherSummaries;

	/** Initializing a set of <code>WeatherSummary</code> objects for testing purpose. */
	static {
		weatherSummaries = new ArrayList<>();
		weatherSummaries.add(new WeatherSummary("Colombo", "CMB", 28.5));
		weatherSummaries.add(new WeatherSummary("Kandy", "KY", 25.2));
		weatherSummaries.add(new WeatherSummary("Kurunegala", "KU", 27));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WeatherSummary findWeatherSummary(String cityCode) {
		return WeatherRepositoryImpl.weatherSummaries.stream()
			.filter(summary -> cityCode.equals(summary.getCityCode())).findFirst().orElse(null);
	}
}
