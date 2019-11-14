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

	
	
	@Test
	public void test_celsius_to_farenheit() {
		
		//Arrange
		//Act
		//Assert
		
		Assert.assertEquals("50 F should be 10C...simple calculation",10, CelsiusCalculator.farenheitToCelsius(50));
		Assert.assertEquals("55 F should round to 13C",13, CelsiusCalculator.farenheitToCelsius(55));
		Assert.assertEquals("55 F should round down to 12C",12, CelsiusCalculator.farenheitToCelsius(54));
		Assert.assertEquals("20 F should round to -7",-7, CelsiusCalculator.farenheitToCelsius(20));
		Assert.assertEquals("-3 F should round to -19",-19, CelsiusCalculator.farenheitToCelsius(-3));
		Assert.assertEquals("0 F should round to -18",-18, CelsiusCalculator.farenheitToCelsius(0));
	}
	
	@Test
	public void test_farenheit_to_celsius() {
		
		//Arrange
		//Act
		//Assert
		
		Assert.assertEquals("10C should be 50F...simple calculation",50, CelsiusCalculator.celsiusToFarenheit(10));
		Assert.assertEquals("0 C should be 32F...simple calculation",32, CelsiusCalculator.celsiusToFarenheit(0));
		Assert.assertEquals("-5C should be 23F",23, CelsiusCalculator.celsiusToFarenheit(-5));
		Assert.assertEquals("-20 C should be -4F",-4, CelsiusCalculator.celsiusToFarenheit(-20));
		Assert.assertEquals("33 C should round to 91",91, CelsiusCalculator.celsiusToFarenheit(33));
		Assert.assertEquals("-33C should round to -27F",-27, CelsiusCalculator.celsiusToFarenheit(-33));
	}
	
	
	
}
