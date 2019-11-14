package com.techelevator.npgeek;

public class CelsiusCalculator {

	private static double temperature;
	/*
	 * @param temperature in farenheit
	 *@return temperature in celsius
	 *
	 */
	public static int farenheitToCelsius(int tempFarenheit) {
		double tempDouble = tempFarenheit;
		tempDouble = (tempDouble-32)*5/9;
		return (int)Math.round(tempDouble);
	}
	
	
	public static double getTemperature() {
		return temperature;
	}
	public static void setTemperature(double temperature) {
		CelsiusCalculator.temperature = temperature;
	}
	
	
}
