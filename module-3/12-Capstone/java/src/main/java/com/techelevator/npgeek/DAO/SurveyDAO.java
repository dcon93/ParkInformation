package com.techelevator.npgeek.DAO;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Survey;


public interface SurveyDAO {
	
	
	public void saveSurvey(Survey newSurvey);
	public Map<String, Integer> getFavoritePark();
}
