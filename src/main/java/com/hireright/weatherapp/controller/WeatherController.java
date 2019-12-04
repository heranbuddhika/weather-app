package com.hireright.weatherapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hireright.weatherapp.constants.Constants;
import com.hireright.weatherapp.service.WeatherService;
import com.hireright.weatherapp.service.WeatherServiceImpl;

@WebServlet("/weather-service")
public class WeatherController extends HttpServlet {

	/** Holds the serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Holds the logger. */
	static final Logger logger = Logger.getLogger(WeatherController.class);

	/** Holds the weatherService instance. */
	private WeatherService weatherService = new WeatherServiceImpl();

	/***
	 * Post method to retrieve weather summary.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("Start of the weather-service doPost()");
		PrintWriter printWriter = res.getWriter();
		res.setContentType(Constants.CONTENT_TYPE);
		res.setCharacterEncoding(Constants.CHAR_ENCODING);
		printWriter.print(weatherService.getWeatherSummary(req.getParameter(Constants.CITY_CODE)));
        printWriter.flush();
        logger.info("Start of the weather-service doPost()");
	}
}
