package com.techelevator.npgeek;


public class Survey {	
	String favoriteNationalPark;
	String email;
	String state;
	String activityLevel; //This can be inactive, sedentary, active, or extremely active
	String parkCode;
	
	
	
	
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFavoriteNationalPark() {
		return favoriteNationalPark;
	}
	public void setFavoriteNationalPark(String favoriteNationalPark) {
		this.favoriteNationalPark = favoriteNationalPark;
	}
	public String getState() {
	return state;
	}
	public void setState(String state) {
		this.state = state;
	}	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	
}