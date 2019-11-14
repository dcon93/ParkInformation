package com.techelevator.npgeek;

public class Weather {

	String parkCode;

	int tempLow; // Stored as Farenheit
	int tempHigh; // Stored as Farenheit
	String forecast;
	int fiveDayForecast;
	String weatherMessage;

	public String getForecast() {
		return forecast.replace(" ", "");
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

	public int getFiveDayForeCast() {
		return fiveDayForecast;
	}

	public void setFiveDayForeCast(int fiveDayForeCast) {
		this.fiveDayForecast = fiveDayForeCast;
	}

	public String getWeatherMessage() {

		if (forecast.equalsIgnoreCase("snow")) {
			if (tempHigh < 20 || tempLow < 20) {
				weatherMessage = "Pack snowshoes and beware exposure to frigid temperatures.";
			} else if (tempHigh - tempLow > 20) {
				weatherMessage = "Pack snowshoes and wear breathable layers.";
			} else if ((tempHigh - tempLow > 20) && tempHigh > 75) {
				weatherMessage = "Pack snowshoes,wear breathable layers and bring an extra gallon of water.";
			} else if (tempHigh > 75) {
				weatherMessage = "Pack snowshoes and bring an extra gallon of water.";
			} else {
				weatherMessage = "Pack snowshoes";
			}
		} else if (forecast.equalsIgnoreCase("rain")) {
			if (tempHigh < 20 || tempLow < 20) {
				weatherMessage = "Pack rain gear and waterproof shoes. Beware of exposure to frigid temperatures.";
			} else if (tempHigh - tempLow > 20) {
				weatherMessage = "Pack rain gear and waterproof shoes. Wear breathable layers.";
			} else if ((tempHigh - tempLow > 20) && tempHigh > 75) {
				weatherMessage = "Pack rain gear,waterproof shoes, wear breathable layers and bring an extra gallon of water.";
			} else if (tempHigh > 75) {
				weatherMessage = "Pack rain gear,waterproof shoes and bring an extra gallon of water.";
			} else {
				weatherMessage = "Pack rain gear and waterproof shoes.";
			}
		} else if (forecast.equalsIgnoreCase("thunderstorms")) {
			if (tempHigh < 20 || tempLow < 20) {
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Beware of exposure to frigid temperatures.";
			} else if (tempHigh - tempLow > 20) {
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Wear breathable layers.";
			} else if ((tempHigh - tempLow > 20) && tempHigh > 75) {
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Wear breathble layers and bring an extra gallon of water.";
			} else if (tempHigh > 75) {
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Bring an extra gallon of water.";
			} else {
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges";
			}
		} else if (forecast.equalsIgnoreCase("sunny")) {
			if (tempHigh < 20 || tempLow < 20) {
				weatherMessage = "Pack sunblock. Beware of exposure to frigid temperatures.";
			} else if (tempHigh - tempLow > 20) {
				weatherMessage = "Pack sunblock. Wear breathable layers.";
			} else if ((tempHigh - tempLow > 20) && tempHigh > 75) {
				weatherMessage = "Pack sunblock, wear breathable layers and bring an extra gallon of water.";
			} else if (tempHigh > 75) {
				weatherMessage = "Pack sunblock and bring an extra gallon of water.";
			} else {
				weatherMessage = "Pack sunblock";
			}
		} else {
			if (tempHigh < 20 || tempLow < 20) {
				weatherMessage = "Beware of exposure to frigid temperatures.";
			} else if (tempHigh - tempLow > 20) {
				weatherMessage = "Wear breathable layers.";
			} else if ((tempHigh - tempLow > 20) && tempHigh > 75) {
				weatherMessage = "Wear breathable layers and bring an extra gallon of water.";
			} else if (tempHigh > 75) {
				weatherMessage = "Bring an extra gallon of water.";
			}
		}

		return weatherMessage;
	}

	public void setWeatherMessage(String weatherMessage) {
		this.weatherMessage = weatherMessage;
	}
}
