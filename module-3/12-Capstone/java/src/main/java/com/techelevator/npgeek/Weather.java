package com.techelevator.npgeek;


public class Weather{
	
	String parkCode;
	int day;
	int tempLow; //Stored as Farenheit
	int tempHigh; //Stored as Farenheit
	String forecast;
	
	
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getTempHigh() {
		return tempHigh;
	}
	public void setTempHigh(int tempHigh) {
		this.tempHigh = tempHigh;
	}
	public int getTempLow() {
		return tempLow;
	}
	public void setTempLow(int tempLow) {
		this.tempLow = tempLow;
	}
	
	
	
	
	
}