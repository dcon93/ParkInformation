package com.techelevator.npgeek;

public class CelsiusCalculator {

	private static double temperature;
	/*
	 * @param temperature in farenheit
	 *@return temperature in celsius
	 *
	 */
	public static double convertFtoC(double f){
		temperature = ((f-32)*0.556);
		return temperature;
	}
	public static double convertCtoF(double c){
		temperature = ((c*1.8)+32);
		return temperature;
		}
	
	
	public static double getTemperature() {
		return temperature;
	}
	public static void setTemperature(double temperature) {
		CelsiusCalculator.temperature = temperature;
	}
	
	
}
