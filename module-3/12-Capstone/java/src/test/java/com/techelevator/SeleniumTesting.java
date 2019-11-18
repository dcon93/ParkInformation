
package com.techelevator;

import static org.junit.Assert.*;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;


public class SeleniumTesting {

	private static WebDriver webDriver;
	
	/* Creating an instance of the WebDriver is time consuming
	 * since it opens up a browser window. Therefore, we do this
	 * only once at the start of the class and reuse the same
	 * browser window for all tests. */
	@BeforeClass
	public static void openWebBrowserForTesting() {
		
		String homeDir = System.getProperty("user.home"); // ~ or $HOME
		/* The ChromeDriver requires a system property with the name "webdriver.chrome.driver" that
		 * contains the directory path to the ChromeDriver executable. The following line assumes
		 * we have installed the ChromeDriver in a known location under our home directory */
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}

	@Before
	public void openHomePage() {
		webDriver.get("http://localhost:8080/m3-java-capstone/");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}
	
	@Test
	public void single_elements_can_be_found_by_tag_name() {
		WebElement header = webDriver.findElement(By.tagName("header"));
		assertNotNull(header);
	}
	
	@Test
	public void forms_can_be_edited_and_submitted() throws InterruptedException {
		WebElement surveyLink = webDriver.findElement(By.linkText("Survey"));
		// calculatorLink.click();
		JavascriptExecutor ex = (JavascriptExecutor)webDriver;
		ex.executeScript("arguments[0].click();", surveyLink);

		
		WebElement amountField = webDriver.findElement(By.name("Email"));
		// The sendKeys(...) method can be used to simulate typing in a field
		amountField.sendKeys("dcon90devin@gmail.com");
		// To interact with a <select> element, wrap the WebElement in a Select object
		Select parkField = new Select(webDriver.findElement(By.name("Favorite Park")));
		parkField.selectByVisibleText("Cuyahoga Valley National Park");
		Select stateField = new Select(webDriver.findElement(By.name("State of Residence")));
		stateField.selectByVisibleText("PA");
		Select activityField = new Select(webDriver.findElement(By.name("Activity Level")));
		activityField.selectByVisibleText("Inactive");
		
		WebElement submitButton = webDriver.findElement(By.className("formSubmitButton"));

		ex.executeScript("arguments[0].click();", submitButton);
		//submitButton.click();
		
		/* Elements without an id can be found using an xPath expression.
		 * However, finding elements by xPath should generally be avoided 
		 * as it is slow and makes for brittle tests. */
		WebElement confirmation = webDriver.findElement(By.tagName("confirmation"));
		assertNotNull(confirmation);
	
	
	}}