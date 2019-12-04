package com.weatherapp.service;

import java.util.Map;

/**
 * Interface for the geo location service.
 * 
 * @author heranbuddhika
 *
 */
public interface GeoLocationService {

	/**
	 * This method returns a response as a string with matching
	 * <code>TimeZone</code> object.
	 * 
	 * @param request
	 * @return response string
	 */
	public String getTimeZone(Map<String, String> request);
}
