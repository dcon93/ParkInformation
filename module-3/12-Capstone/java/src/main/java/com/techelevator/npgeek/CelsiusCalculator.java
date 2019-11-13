package com.techelevator.npgeek;

public class CelsiusCalculator {

	
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
	
	
	
	
	
}
