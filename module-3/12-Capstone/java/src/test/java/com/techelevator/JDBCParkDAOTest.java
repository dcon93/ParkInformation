package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.AssertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.DAO.JDBCParkDAO;
import com.techelevator.npgeek.DAO.JDBCSurveyDAO;


public class JDBCParkDAOTest extends DAOIntegrationTest{
	private static final String TEST_PARK_NAME = "Testing Test Park";
	private static final String TEST_PARK_CODE = "TESTCODE";
	private static final String TEST_PARK_TEXT = "TESTtext";
	
	private static final int TEST_PARK_STATS = 1337;
	private static final float TEST_PARK_FLOAT = 133.7F;
	private static final double FUDGE_FACTOR = .01;
	private Park generalTestPark;
	
	

	private String parkCode;
	private JDBCParkDAO parkDAO;
	private JdbcTemplate jdbcTemplate;

	@Before
	public void make_DAO() {
		parkDAO = new JDBCParkDAO(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());
		addPark(TEST_PARK_CODE);
	}
	
	public String addPark(String parkCodeParam) {
		String sqlMakePark = "INSERT INTO park (parkcode, parkname, state, "
							+ "acreage, elevationinfeet, milesoftrail, numberofcampsites, "
							+ "climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, "
							+ "parkdescription, entryfee, numberofanimalspecies) "
							+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) "
							+ "RETURNING parkcode";
		parkCode = jdbcTemplate.queryForObject(sqlMakePark,String.class,parkCodeParam,TEST_PARK_NAME,
											TEST_PARK_TEXT,TEST_PARK_STATS,TEST_PARK_STATS,TEST_PARK_FLOAT,TEST_PARK_STATS,
											TEST_PARK_TEXT, TEST_PARK_STATS, TEST_PARK_STATS,TEST_PARK_TEXT, TEST_PARK_TEXT,
											TEST_PARK_TEXT, TEST_PARK_STATS, TEST_PARK_STATS);
				
		return parkCode;
	}
	@Test
	public void test_get_park_by_code() {
		Park expectedPark = createPark();
		
		Park actualPark = parkDAO.getParkByParkCode(parkCode);
				assertParkEqual(expectedPark, actualPark);
	}
	
	@Test
	public void test_get_all_parks() {
		int parkCount1 = parkDAO.getAllParks().size();
		addPark("TESTCode2");
		List<Park> parks = parkDAO.getAllParks();
		int parkCount2 = parks.size();
		boolean hasTestCode = false;
		boolean hasNewTestCode = false;
		for(Park park : parks) {
			if(park.getParkCode().contentEquals(TEST_PARK_CODE)) {
				hasTestCode = true;
			}
			if(park.getParkCode().contentEquals("TESTCode2"))
				hasNewTestCode = true;
		}		
		assertTrue(hasTestCode);
		assertTrue(hasNewTestCode);
		assertEquals(parkCount1+1, parkCount2);
	}
	
	//Matches park created before each class
	public Park createPark() {
		Park park = new Park();
		park.setAcreage(TEST_PARK_STATS);
		park.setAnnualVisitorCount(Integer.toString(TEST_PARK_STATS));
		park.setClimate(TEST_PARK_TEXT);
		park.setElevationInFeet(TEST_PARK_STATS);
		park.setEntryFee(TEST_PARK_STATS);
		park.setInspirationalQuote(TEST_PARK_TEXT);
		park.setInspirationalQuoteSource(TEST_PARK_TEXT);
		park.setMilesOfTrail(TEST_PARK_FLOAT);
		park.setNumberOfAnimalSpecies(Integer.toString(TEST_PARK_STATS));
		park.setNumberOfCampsites(TEST_PARK_STATS);
		park.setParkCode(TEST_PARK_CODE);
		park.setParkName(TEST_PARK_NAME);
		park.setQuoteSource(TEST_PARK_TEXT);
		park.setState(TEST_PARK_TEXT);
		park.setYearFounded(Integer.toString(TEST_PARK_STATS));
		park.setParkDescription(TEST_PARK_TEXT);
		return park;
	}
	
	public void assertParkEqual(Park expected, Park actual) {
		
		assertEquals(expected.getAcreage(), actual.getAcreage());
		assertEquals(expected.getAnnualVisitorCount(), actual.getAnnualVisitorCount());
		assertEquals(expected.getClimate(), actual.getClimate());
		assertEquals(expected.getElevationInFeet(), actual.getElevationInFeet());
		assertEquals(expected.getEntryFee(), actual.getEntryFee());
		assertEquals(expected.getInspirationalQuote(), actual.getInspirationalQuote());
		assertEquals(expected.getInspirationalQuoteSource(), actual.getInspirationalQuoteSource());
		assertEquals(expected.getMilesOfTrail(), actual.getMilesOfTrail(),FUDGE_FACTOR);
		assertEquals(expected.getNumberOfAnimalSpecies(), actual.getNumberOfAnimalSpecies());
		assertEquals(expected.getNumberOfCampsites(), actual.getNumberOfCampsites());
		assertEquals(expected.getParkCode(), actual.getParkCode());
		assertEquals(expected.getParkDescription(), actual.getParkDescription());
		assertEquals(expected.getParkName(), actual.getParkName());
		assertEquals(expected.getYearFounded(), actual.getYearFounded());
		assertEquals(expected.getState(), actual.getState());
		
	}
		
	
	
	




}
