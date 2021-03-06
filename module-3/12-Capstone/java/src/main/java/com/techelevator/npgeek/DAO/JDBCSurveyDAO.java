package com.techelevator.npgeek.DAO;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Survey;
import javax.sql.DataSource;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;
	


	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}



	@Override
	public void saveSurvey(Survey newSurvey) {
			String sqlSaveSurvey = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";
			jdbcTemplate.update(sqlSaveSurvey, newSurvey.getParkCode(), newSurvey.getEmail(), newSurvey.getState(), newSurvey.getActivityLevel());
			
		}

	
	public Survey getSurveyById(Long id) {
		String sqlGetSurvey = "SELECT surveyid, parkcode, emailaddress, state, activitylevel "
								+ "FROM survey_result "
								+ "WHERE surveyid = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetSurvey, id);
		Survey survey = new Survey();
		if(results.next()) {
			survey.setActivityLevel(results.getString("activitylevel"));
			survey.setEmail(results.getString("emailaddress"));
			survey.setParkCode(results.getString("parkcode"));
			survey.setState(results.getString("state"));
			survey.setSurveyId(results.getLong("surveyid"));
		}
		return survey;
		
	}


	@Override
	public Map<String, Integer> getFavoritePark() {
		Map<String, Integer> favoriteParks = new LinkedHashMap<>();
		String sqlSelectTopFiveParks = "SELECT parkcode, COUNT(parkcode) AS countpark FROM survey_result GROUP BY parkcode ORDER BY countpark DESC LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectTopFiveParks);
		while (results.next()){
			favoriteParks.put(results.getString("parkcode"), results.getInt("countpark"));
			
		}
		return favoriteParks;
	}
	}
	

	
