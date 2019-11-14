package com.techelevator.npgeek;

import java.util.HashMap;

import java.util.Map;
import java.util.Map.Entry;
import com.techelevator.npgeek.DAO.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class SurveyController {

	
	@Autowired
	SurveyDAO surveyDAO;
	
	@Autowired
	ParkDAO parkDAO;
	
	//Change what is in quotes once we are done with the jsp files
	@RequestMapping(path="/survey",method=RequestMethod.GET)
	public String showSurvey(ModelMap modelHolder) {
		if (! modelHolder.containsAttribute("survey")) {
			modelHolder.put("survey", new Survey());
		}
		modelHolder.put("parks",parkDAO.getAllParks());
		modelHolder.put("usaStates",States.values());
	return "survey";
	
	}
	
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String processSurvey(@Valid @ModelAttribute("survey") Survey newSurvey, BindingResult result, RedirectAttributes flash) {
		flash.addFlashAttribute("survey", newSurvey);
		
		if (result.hasErrors()) {
			flash.addFlashAttribute("survey", newSurvey);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/survey";
		}
		surveyDAO.saveSurvey(newSurvey);
		
		return "redirect:/confirmation";
	}
	
	@RequestMapping(path="/confirmation",method=RequestMethod.POST)
	public String showConfirmation(ModelMap modelHolder) {
		Map<String, Integer> topParks = surveyDAO.getFavoritePark();
		Map<String, Park> parkList= new HashMap<>();
		
		for(Entry<String, Integer> entry : topParks.entrySet()) {
			parkList.put(entry.getKey(),parkDAO.getParkByParkCode(entry.getKey()));
		}
		 modelHolder.put("topParks", topParks);
		 modelHolder.put("parkList", parkList);
		
		return "redirect:/placeholderforconfirmationjsp";
	}
	
	@RequestMapping(path="/placeholderfortopParks",method=RequestMethod.GET)
	public String showTopParks(ModelMap modelHolder) {
		Map<String, Integer> topParks = surveyDAO.getFavoritePark();
		Map<String, Park> parkList= new HashMap<>();
		
		for(Entry<String, Integer> entry : topParks.entrySet()) {
			parkList.put(entry.getKey(),parkDAO.getParkByParkCode(entry.getKey()));
		}
		 modelHolder.put("topParks", topParks);
		 modelHolder.put("parkList", parkList);
		
		return "placeholderfortopParks";
	}
	
	
	
}
