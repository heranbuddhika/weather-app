package com.hireright.weatherapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hireright.weatherapp.constants.Constants;
import com.hireright.weatherapp.service.GeoLocationService;
import com.hireright.weatherapp.service.GeoLocationServiceImpl;
import com.hireright.weatherapp.util.JsonConverter;

/**
 * This is the controller class for geo location related services.
 * 
 * @author heranbuddhika
 *
 */
@WebServlet("/geo-service")
public class GeoLocationController extends HttpServlet {

	/** Holds the serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Holds the logger. */
	static final Logger logger = Logger.getLogger(GeoLocationController.class);

	/** Holds the geoLocationService instance. */
	private GeoLocationService geoLocationService = new GeoLocationServiceImpl();

	/** Holds the geoLocationService instance. */
	JsonConverter converter = new JsonConverter();

	/***
	 * Post method to retrieve time zone.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("Start of the geo-service doPost()");
		PrintWriter printWriter = res.getWriter();
		res.setContentType(Constants.CONTENT_TYPE);
		res.setCharacterEncoding(Constants.CHAR_ENCODING);
		printWriter.print(geoLocationService.getTimeZone(requestConvert(req)));
        printWriter.flush();
        logger.info("End of the geo-service doPost()");
	}

	/**
	 * This method used to convert the request json to a map.
	 * 
	 * @param req
	 * @return retuns the converted map.
	 * @throws IOException
	 */
	private Map<String, String> requestConvert(HttpServletRequest req) throws IOException {
		String jsonString = req.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));

		return converter.convertJsonToMap(jsonString);
	}
}
