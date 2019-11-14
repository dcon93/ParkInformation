package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.DAO.JDBCSurveyDAO;
public class JDBCSurveyDAOTest extends DAOIntegrationTest {
	private static final String TEST_EMAIL = "myemail@test.com";
	private static final String TEST_PARK_CODE = "TESTCODE";
	private Long testId;
	private JDBCSurveyDAO surveyDAO;
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Before
	public void make_DAO() {
		surveyDAO = new JDBCSurveyDAO(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());
		addToDB();
	}
	
	public Long addToDB() {
		String sqlMakeSurvey = 	"INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) "
				+ "VALUES (?,?,?,?) RETURNING surveyid";
		testId = jdbcTemplate.queryForObject(sqlMakeSurvey, Long.TYPE, TEST_PARK_CODE, TEST_EMAIL,"VA","extremely active");
		return testId; 
	}
	@Test
	public void test_get_survey_by_ID() {
		Survey expectedSurvey = createSurvey(testId, TEST_PARK_CODE, TEST_EMAIL, "VA", "extremely active");
		Survey actualSurvey = surveyDAO.getSurveyById(testId);
		assertSurveyEqual(expectedSurvey, actualSurvey);
		
	}
	
	@Test
	public void test_save_survey() {
		Survey expectedSurvey = createSurvey(testId+1,TEST_PARK_CODE, TEST_EMAIL, "VA", "extremely active");
		surveyDAO.saveSurvey(expectedSurvey);
		Survey actualSurvey = surveyDAO.getSurveyById(testId+1);
		assertSurveyEqual(expectedSurvey, actualSurvey);

	}
	
	@Test
	public void test_get_favorite_park() {
		
		for(int i = 0;i<20;i++) {
			addToDB();
		}
		Map<String, Integer> favesies = surveyDAO.getFavoritePark();
		Integer actual = favesies.get(TEST_PARK_CODE);
		Integer expected = 21;
		assertEquals(expected,actual);
				
	}

	public static void assertSurveyEqual(Survey expected, Survey actual) {
		assertEquals(expected.getActivityLevel(), actual.getActivityLevel());
		assertEquals(expected.getEmail(), actual.getEmail());
		assertEquals(expected.getParkCode(), actual.getParkCode());
		assertEquals(expected.getState(), actual.getState());
		assertEquals(expected.getSurveyId(), actual.getSurveyId());		
	}
	

	private Survey createSurvey(Long surveyId, String parkCode, String emailAddress, String state, String activityLevel) {
		Survey testSurvey = new Survey();
		testSurvey.setSurveyId(surveyId);
		testSurvey.setParkCode(parkCode);
		testSurvey.setEmail(emailAddress);
		testSurvey.setState(state);
		testSurvey.setActivityLevel(activityLevel);
		return testSurvey;
		
	}
	private Survey createSurvey( String parkCode, String emailAddress, String state, String activityLevel) {
		Survey testSurvey = new Survey();
		testSurvey.setParkCode(parkCode);
		testSurvey.setEmail(emailAddress);
		testSurvey.setState(state);
		testSurvey.setActivityLevel(activityLevel);
		return testSurvey;
		
	}
	
}
