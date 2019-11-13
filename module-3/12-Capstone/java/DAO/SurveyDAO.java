import java.util.Map;

public interface SurveyDAO {

	public void saveSurvey(Survey newSurvey);
	public Map<String, Integer> getFavoritePark();
}
