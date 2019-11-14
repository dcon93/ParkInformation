package com.techelevator.npgeek;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.DAO.ParkDAO;

@Controller
public class SiteController {

	@Autowired
	ParkDAO parkDAO;

	@Autowired
	WeatherDAO weatherDAO;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showHomePage(ModelMap modelHolder, @ModelAttribute Park newNationalPark) {
		List<Park> newParkList = parkDAO.getAllParks();
		modelHolder.put("parks", newParkList);

		return "homePage";

	}

	@RequestMapping(path = "/parkDetail/{parkCode}", method = RequestMethod.GET)
	public String showParkDetail(@PathVariable String parkCode, HttpSession session, ModelMap modelHolder) {
		String convert = (String) session.getAttribute("convert");
		if (convert == null) {
			convert = "F";
			session.setAttribute("convert", convert);
		}

		List<Weather> newWeatherList = weatherDAO.getWeatherByParkcode(parkCode);
		Park newPark = parkDAO.getParkByParkCode(parkCode);
		//System.out.println(newPark.getParkName());
		if (convert.equals("C")) {
			for (Weather tempWeather : newWeatherList) {
				int tempVar;

				// need to import conversion class for these next four lines to work not sure what you named them
				tempVar = (int) CelsiusCalculator.farenheitToCelsius(tempWeather.getTempHigh());
				tempWeather.setTempHigh(tempVar);
				tempVar = (int) CelsiusCalculator.celsiusToFarenheit(tempWeather.getTempLow());
				tempWeather.setTempLow(tempVar);
			}


			
		}
		modelHolder.put("park", newPark);
		modelHolder.put("parkWeather", newWeatherList);
		return "parkDetail";

	}
	
	@RequestMapping(path="/parkDetail/{parkCode}",method=RequestMethod.POST)
	public String showParkDetailWithConversion(@PathVariable String parkCode, @RequestParam String convert, HttpSession session, ModelMap modelHolder){
		session.setAttribute("convert", convert);
		
		return "redirect:/parkDetail/" + parkCode;
	}

}
