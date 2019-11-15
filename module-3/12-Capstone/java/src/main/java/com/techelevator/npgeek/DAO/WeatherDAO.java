package com.techelevator.npgeek.DAO;

import java.util.List;

import com.techelevator.npgeek.Weather;

public interface WeatherDAO {
	public List<Weather> getWeatherByParkcode(String parkCode);
}
