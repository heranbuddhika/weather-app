package com.weatherapp.dto;

/**
 * Time Zone DTO.
 * 
 * @author heranbuddhika
 *
 */
public class TimeZone {

	private String zipCode;

	private String zone;

	private String GMT;

	public TimeZone(String zipCode, String timeZone, String gMT) {
		super();
		this.zipCode = zipCode;
		this.zone = timeZone;
		GMT = gMT;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTimeZone() {
		return zone;
	}

	public void setTimeZone(String timeZone) {
		this.zone = timeZone;
	}

	public String getGMT() {
		return GMT;
	}

	public void setGMT(String gMT) {
		GMT = gMT;
	}
}
