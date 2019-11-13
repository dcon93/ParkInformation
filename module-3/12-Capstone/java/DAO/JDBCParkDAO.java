import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCParkDAO implements ParkDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public ArrayList<Park> getAllParks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
