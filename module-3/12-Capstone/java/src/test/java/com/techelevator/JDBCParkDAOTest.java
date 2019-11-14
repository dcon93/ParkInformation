package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.DAO.JDBCParkDAO;
import com.techelevator.npgeek.DAO.JDBCSurveyDAO;


public class JDBCParkDAOTest extends DAOIntegrationTest{
	private static final String TEST_EMAIL = "myemail@test.com";
	private static final String TEST_PARK_CODE = "TESTCODE";
	private Long testId;
	private JDBCParkDAO parkDAO;
	private JdbcTemplate jdbcTemplate;
}
