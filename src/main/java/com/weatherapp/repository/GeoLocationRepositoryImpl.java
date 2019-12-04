package com.weatherapp.repository;

import java.util.ArrayList;
import java.util.List;

import com.weatherapp.dto.TimeZone;

/**
 * Implementation class for the <code>GeoLocationRepository</code>.
 * 
 * @author heranbuddhika
 *
 */
public class GeoLocationRepositoryImpl implements GeoLocationRepository {

	/** Holds a list of <code>TimeZone</code> objects. */
	static List<TimeZone> timeZones;

	/** Initializing a set of <code>TimeZone</code> objects for testing purpose. */
	static {
		timeZones = new ArrayList<>();
		timeZones.add(new TimeZone("47578", "EST", "-5"));
		timeZones.add(new TimeZone("83870", "PST", "-8"));
		timeZones.add(new TimeZone("65046", "CST", "-6"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TimeZone findTimeZone(String zipCode) {
		return GeoLocationRepositoryImpl.timeZones.stream().filter(timeZone -> zipCode.equals(timeZone.getZipCode()))
				.findFirst().orElse(null);
	}
}
