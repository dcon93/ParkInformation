package com.techelevator.npgeek.DAO;
import java.util.List;
import java.util.ArrayList;

import com.techelevator.npgeek.Park;

public interface ParkDAO {
	public ArrayList<Park> getAllParks();
	public Park getParkByParkCode(String parkCode);

}
