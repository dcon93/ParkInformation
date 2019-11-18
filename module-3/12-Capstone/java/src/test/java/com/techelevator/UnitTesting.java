package com.techelevator;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.CelsiusCalculator;

public class UnitTesting {
	
	final static double FUDGE_FACTOR=.01;

	
	
	@Test
	public void test_celsius_to_farenheit() {
		
		//Arrange
		//Act
		//Assert
		
		Assert.assertEquals("50 F should be 10C...simple calculation",10, CelsiusCalculator.convertFtoC(50),FUDGE_FACTOR);
		Assert.assertEquals("55 F should be 12.79C",12.79, CelsiusCalculator.convertFtoC(55),FUDGE_FACTOR);
		Assert.assertEquals("55 F should be to 12.23C",12.23, CelsiusCalculator.convertFtoC(54),FUDGE_FACTOR);
		Assert.assertEquals("20 F should be -6.67",-6.67, CelsiusCalculator.convertFtoC(20),FUDGE_FACTOR);
		Assert.assertEquals("-3 F should be -19.46",-19.46, CelsiusCalculator.convertFtoC(-3),FUDGE_FACTOR);
		Assert.assertEquals("0 F should be -17.79",-17.79, CelsiusCalculator.convertFtoC(0),FUDGE_FACTOR);
	}
	
	@Test
	public void test_farenheit_to_celsius() {
		
		//Arrange
		//Act
		//Assert
		
		Assert.assertEquals("10C should be 50F...simple calculation",50, CelsiusCalculator.convertCtoF(10),FUDGE_FACTOR);
		Assert.assertEquals("0 C should be 32F...simple calculation",32, CelsiusCalculator.convertCtoF(0),FUDGE_FACTOR);
		Assert.assertEquals("-5C should be 23F",23, CelsiusCalculator.convertCtoF(-5),FUDGE_FACTOR);
		Assert.assertEquals("-20 C should be -4F",-4, CelsiusCalculator.convertCtoF(-20),FUDGE_FACTOR);
		Assert.assertEquals("33 C be 91.4",91.4, CelsiusCalculator.convertCtoF(33),FUDGE_FACTOR);
		Assert.assertEquals("-33C be -27.4F",-27.4, CelsiusCalculator.convertCtoF(-33),FUDGE_FACTOR);
	}
	
	
	
}
