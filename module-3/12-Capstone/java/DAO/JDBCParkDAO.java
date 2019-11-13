import java.awt.List;
import java.util.ArrayList;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.Park;

public class JDBCParkDAO implements ParkDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public ArrayList<Park> getAllParks() {
		ArrayList<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()){
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		Park newPark = null;
		String sqlSelectParkByParkCode = "SELECT * FROM park WHERE parkcode=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByParkCode, parkCode);
		if(results.next()){
			newPark = mapRowToPark(results);
		}
		return newPark;
	}
	
	
	public Park mapRowToPark(SqlRowSet row) {
		return null;
	
}
	
}
