import java.awt.List;
import java.util.ArrayList;

import com.techelevator.npgeek.Park;

public interface ParkDAO {
	public ArrayList<Park> getAllParks();
	public Park getParkByParkCode(String parkCode);

}
