package com.hireright.weatherapp.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.hireright.weatherapp.constants.Constants;
import com.hireright.weatherapp.dto.WeatherSummary;
import com.hireright.weatherapp.repository.WeatherRepository;
import com.hireright.weatherapp.repository.WeatherRepositoryImpl;
import com.hireright.weatherapp.util.JsonConverter;

/**
 * Implementation class for the <code>WeatherService</code>.
 * 
 * @author heranbuddhika
 *
 */
public class WeatherServiceImpl implements WeatherService {

	/** Holds the logger. */
	static final Logger logger = Logger.getLogger(WeatherServiceImpl.class);

	/** Holds the weather repository instance. */
	private WeatherRepository weatherRepository = new WeatherRepositoryImpl();

	/** Holds the json converter instance. */
	JsonConverter converter = new JsonConverter();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getWeatherSummary(String cityCode) {
		Map<String, Object> response = new HashMap<String, Object>();
		WeatherSummary weatherSummary;

		if (cityCode != null && !cityCode.isEmpty()) {
			weatherSummary = weatherRepository.findWeatherSummary(cityCode);

			if (weatherSummary != null) {
				response.put(Constants.STATUS, Constants.SUCCESS);
				response.put(Constants.MESSAGE, weatherSummary);
				logger.info("Weather summary for city code: " + cityCode);
				logger.info(weatherSummary);
			} else {
				response.put(Constants.STATUS, Constants.ERROR);
				response.put(Constants.MESSAGE, "No weather summaries fount for city code: " + cityCode);
				logger.error("No weather summaries fount for city code: " + cityCode);
			}
		} else {
			response.put(Constants.STATUS, Constants.ERROR);
			response.put(Constants.MESSAGE, "City code: " + cityCode + "is invalid.");
			logger.error("City code: " + cityCode + "is invalid.");
		}
        return converter.convertMapToJson(response);
	}
}
