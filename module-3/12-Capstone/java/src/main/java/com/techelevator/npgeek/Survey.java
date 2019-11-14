package com.techelevator.npgeek;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


public class Survey {	
	
//	@NotBlank(message="Park is required")
//	String favoriteNationalPark;
	
	@NotBlank(message="Last Name is required")
	@Email(message="Email must be a valid email address")
	String email;
	
	@NotBlank(message="State is required")
	String state;
	
	@NotBlank(message="Activity Level is required")
	String activityLevel; //This can be inactive, sedentary, active, or extremely active
	
	@NotBlank( message="Park is required")
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
//	public String getFavoriteNationalPark() {
//		return favoriteNationalPark;
//	}
//	public void setFavoriteNationalPark(String favoriteNationalPark) {
//		this.favoriteNationalPark = favoriteNationalPark;
//	}
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
