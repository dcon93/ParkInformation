package com.techelevator.npgeek.DAO;
import java.awt.List;
import java.util.ArrayList;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Park;


@Component
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
		Park newPark = new Park();
		newPark.setParkCode(row.getString("parkcode"));
		newPark.setParkName(row.getString("parkname"));
		newPark.setState(row.getString("state"));
		newPark.setAcreage(row.getInt("acreage"));
		newPark.setElevationInFeet(row.getInt("elevationinfeet"));
		newPark.setMilesOfTrail(row.getFloat("milesoftrail"));
		newPark.setNumberOfCampsites(row.getInt("numberofcampsites"));
		newPark.setClimate(row.getString("climate"));
		newPark.setYearFounded(row.getString("yearfounded"));
		newPark.setAnnualVisitorCount(row.getString("annualvisitorcount"));
		newPark.setInspirationalQuote(row.getString("inspirationalquote"));
		newPark.setInspirationalQuoteSource(row.getString("inspirationalquotesource"));
		newPark.setParkDescription(row.getString("parkdescription"));
		newPark.setEntryFee(row.getInt("entryfee"));
		newPark.setNumberOfAnimalSpecies(row.getString("numberofanimalspecies"));
		
		return newPark;
	}
	
}
	
}
