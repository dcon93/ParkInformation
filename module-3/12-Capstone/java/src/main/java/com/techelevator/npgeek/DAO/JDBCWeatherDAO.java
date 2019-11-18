package com.techelevator.npgeek.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Weather;


@Component
public class JDBCWeatherDAO implements WeatherDAO {

	
	
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<Weather> getWeatherByParkcode(String parkCode) {
		
		List<Weather> parkWeather = new ArrayList<>();
		String sqlSelectParkWeather = "SELECT * FROM weather WHERE parkcode=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkWeather, parkCode);
		while(results.next()){
			parkWeather.add(mapRowToWeather(results));
		}
		
		return parkWeather;
	}
	
	private Weather mapRowToWeather(SqlRowSet row){
		Weather newWeather = new Weather();
		newWeather.setFiveDayForeCast(row.getInt("fivedayforecastvalue"));
		newWeather.setForecast(row.getString("forecast"));
		newWeather.setTempHigh(row.getInt("high"));
		newWeather.setTempLow(row.getInt("low"));
		return newWeather;
	}
	
	

}
