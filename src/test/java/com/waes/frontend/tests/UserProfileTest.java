package com.waes.frontend.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

import com.waes.frontend.pageObjects.home.HomePage;
import com.waes.frontend.webdriver.DriverSetup;

public class UserProfileTest {
	static WebDriver driver; 
	static DriverSetup setup;
	
	@BeforeEach
	public void Initialize() {
		setup = new DriverSetup();
		driver = setup.setupWebDriver();
	}
	
	@ParameterizedTest
	@CsvSource({"admin, hero, Amazing Admin"})
	public void testUserProfile(String userName, String password, String name) {
		
		new HomePage()
		.accessURL(driver, "https://waesworks.bitbucket.io/")
		.accessLoginPage(driver)
		.fillUserData(driver, userName, password) 
		.confirmLogin(driver)
		.verifyUserProfile(driver, name);	
		
	}
	
	@AfterEach
	public void FinishTests() {
		setup.closeDriver(driver);
	}
}
