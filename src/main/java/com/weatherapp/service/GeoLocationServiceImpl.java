package com.weatherapp.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.weatherapp.constants.Constants;
import com.weatherapp.dto.TimeZone;
import com.weatherapp.repository.GeoLocationRepository;
import com.weatherapp.repository.GeoLocationRepositoryImpl;
import com.weatherapp.util.JsonConverter;

/**
 * Implementation class for the <code>GeoLocationService</code>.
 * 
 * @author heranbuddhika
 *
 */
public class GeoLocationServiceImpl implements GeoLocationService {

	/** Holds the logger. */
	static final Logger logger = Logger.getLogger(GeoLocationServiceImpl.class);

	/** Holds the geo location repository instance. */
	private GeoLocationRepository geoLocationRepo = new GeoLocationRepositoryImpl();

	/** Holds the json converter instance. */
	JsonConverter converter = new JsonConverter();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTimeZone(Map<String, String> request) {
		Map<String, Object> response = new HashMap<String, Object>();
		TimeZone timeZone;
		String zipCode = request.get(Constants.ZIP_CODE);

		if (zipCode != null && !zipCode.isEmpty()) {
			timeZone = geoLocationRepo.findTimeZone(zipCode);

			if (timeZone != null) {
				response.put(Constants.STATUS, Constants.SUCCESS);
				response.put(Constants.MESSAGE, timeZone);
				logger.info("Time zone for zip code: " + zipCode);
				logger.info(timeZone);
			} else {
				response.put(Constants.STATUS, Constants.ERROR);
				response.put(Constants.MESSAGE, "No time zone found for zip code: " + zipCode);
				logger.error("No time zone found for zip code: " + zipCode);
			}
		} else {
			response.put(Constants.STATUS, Constants.ERROR);
			response.put(Constants.MESSAGE, "Zip code: " + zipCode + "is invalid.");
			logger.error("Zip code: " + zipCode + "is invalid.");
		}
		return converter.convertMapToJson(response);
	}
}
