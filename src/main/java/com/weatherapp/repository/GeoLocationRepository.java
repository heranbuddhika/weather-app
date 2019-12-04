package com.weatherapp.repository;

import com.weatherapp.dto.TimeZone;

/**
 * Interface for the geo location repository.
 * 
 * @author heranbuddhika
 *
 */
public interface GeoLocationRepository {

	/**
	 * This method returns a time zone object which matches the given zip code.
	 * 
	 * @param zipCode
	 * @return returns a <code>TimeZone</code> object.
	 */
	public TimeZone findTimeZone(String zipCode);
}
