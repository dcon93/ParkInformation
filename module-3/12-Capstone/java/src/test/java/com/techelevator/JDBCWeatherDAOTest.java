package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.DAO.JDBCSurveyDAO;
import com.techelevator.npgeek.Weather;

import com.techelevator.npgeek.DAO.JDBCWeatherDAO;


public class JDBCWeatherDAOTest extends DAOIntegrationTest {
	private static final String TEST_PARK_CODE = "GNP";
	private static final int TEST_TEMP_HIGH = 12;
	private static final int TEST_TEMP_LOW = 109;
	private static final String TEST_MESSAGE = "test message";
	private static final String TEST_FORECAST = "test forecast";
	

	private Long testId;
	private JDBCWeatherDAO weatherDAO;
	private JdbcTemplate jdbcTemplate;

	@Before
	public void make_DAO() {
		weatherDAO = new JDBCWeatherDAO(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());
	}
	@Test
	public void test_get_weather_by_park_code() {
	
		String sqlInsertWeather = "INSERT INTO weather (fivedayforecastvalue, forecast, "
								+ "high, low, parkcode)"
								+ "VALUES(?,?,?,?,?) ";
		Weather testWeather1 = createForecast(16);
		Weather testWeather2 = createForecast(17);
		Weather testWeather = testWeather1;
		
		jdbcTemplate.update(sqlInsertWeather, testWeather.getFiveDayForeCast(),testWeather.getForecast(),
								testWeather.getTempHigh(),testWeather.getTempLow(),testWeather.getParkCode());
		testWeather = testWeather2;
		jdbcTemplate.update(sqlInsertWeather, testWeather.getFiveDayForeCast(),testWeather.getForecast(),
				testWeather.getTempHigh(),testWeather.getTempLow(),testWeather.getParkCode());
		List<Weather> results = weatherDAO.getWeatherByParkcode(TEST_PARK_CODE);
		//assertEquals(Integer.parseInt("7"), results.size());
		boolean foundDay16 = false;
		boolean foundDay17 = false;
		for(int i = results.size()-1; i>=0;i--) {
			if(results.get(i).getFiveDayForeCast()==16) {
				foundDay16 = true;
				assertWeatherEqual(testWeather1, results.get(i));
				
			}
			if(results.get(i).getFiveDayForeCast()==17) {
				foundDay17 = true;
				assertWeatherEqual(testWeather2, results.get(i));
			}
			assertTrue(foundDay16);
			assertTrue(foundDay17);
		}
		
		assertWeatherEqual(testWeather2, results.get(1));
	}
	
	
	public Weather createForecast(int dayNum){
		Weather weather = new Weather();
		weather.setFiveDayForeCast(dayNum);
		weather.setForecast(TEST_FORECAST);
		weather.setParkCode(TEST_PARK_CODE);
		weather.setTempHigh(TEST_TEMP_HIGH);
		weather.setTempLow(TEST_TEMP_LOW);
		weather.setWeatherMessage(TEST_MESSAGE);
		return weather;
		
		
		
	}	
	
	public void assertWeatherEqual(Weather expected, Weather actual) {
		assertEquals(expected.getFiveDayForeCast(), actual.getFiveDayForeCast());
		assertEquals(expected.getForecast(), actual.getForecast());
		assertEquals(expected.getParkCode(), actual.getParkCode());
		assertEquals(expected.getTempHigh(), actual.getTempHigh());
		assertEquals(expected.getTempLow(), actual.getTempLow());
		assertEquals(expected.getWeatherMessage(), actual.getWeatherMessage());
	}
}

