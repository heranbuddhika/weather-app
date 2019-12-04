package com.weatherapp.util;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class used to convert json to java objects and vice versa.
 * 
 * @author heranbuddhika
 *
 */
public class JsonConverter {

	/** Holds the gson object. */
	private final Gson gson;

	/**
	 * Factory mehod to create gson object.
	 */
	public JsonConverter() {
		gson = new GsonBuilder().create();
	}

	/**
	 * This method converts a given <code>Map</code> object to a java string.
	 * 
	 * @param mapToConvert
	 * @return converted string.
	 */
	public String convertMapToJson(Map<String, Object> mapToConvert) {
		return gson.toJson(mapToConvert);
	}

	/**
	 * This method converts a given string to a <code>Map</code> object.
	 * 
	 * @param jsonToConvert
	 * @return converted <code>Map</code>.
	 */
	public Map<String, String> convertJsonToMap(String jsonToConvert) {
		return gson.fromJson(jsonToConvert, Map.class);
	}
}
