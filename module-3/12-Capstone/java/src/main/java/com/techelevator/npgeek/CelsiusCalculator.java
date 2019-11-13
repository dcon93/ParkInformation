package com.techelevator.npgeek;

public class CelsiusCalculator {

	
	public static int farenheitToCelsius(int temp) {
		double tempDouble = temp;
		tempDouble = (tempDouble-32)*5/9;
		return (int)Math.round(tempDouble);
	}
	
	
	
	
	
}
