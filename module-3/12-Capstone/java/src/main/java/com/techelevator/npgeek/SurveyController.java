package com.techelevator.npgeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SurveyController {

	
	@Autowired
	SurveyDAO surveyDao;
	
	@Autowired
	ParkDAO parkDao;
	
	
	@RequestMapping(path="/placeholderForSurvey",method=RequestMethod.GET)
	public String showSurvey(ModelMap modelHolder) {
		if (! modelHolder.containsAttribute("placeholderForSurvey")) {
			modelHolder.put("survey", new Survey());
		}

	return "placeholderForSurvey";
	
	}
}
