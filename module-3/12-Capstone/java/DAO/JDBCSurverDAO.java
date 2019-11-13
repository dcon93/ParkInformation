import java.util.Map;

import com.techelevator.npgeek.Survey;

public interface JDBCSurverDAO {

	public void saveSurvey(Survey newSurvey);
	public Map<String, Integer> getFavoritePark();
}
