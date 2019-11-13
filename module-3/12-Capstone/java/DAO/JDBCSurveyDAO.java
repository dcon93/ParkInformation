import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Survey;


@Component
public class JDBCSurveyDAO {
private JdbcTemplate jdbcTemplate;
	


	@Autowired
	public JdbcSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveSurvey(Survey newSurvey) {
		String sqlSaveSurvey = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlSaveSurvey, newSurvey.getParkCode(), newSurvey.getEmail(), newSurvey.getState(), newSurvey.getActivityLevel());

	}
	
}
