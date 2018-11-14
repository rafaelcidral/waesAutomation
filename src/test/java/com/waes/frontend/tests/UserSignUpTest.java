package com.waes.frontend.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.waes.frontend.pageObjects.home.HomePage;
import com.waes.frontend.webdriver.DriverSetup;

import junitparams.JUnitParamsRunner;


@RunWith(JUnitParamsRunner.class)
class UserSignUpTest {
	
	static WebDriver driver; 
	static DriverSetup setup;
	
	@BeforeEach
	public void Initialize() {
		setup = new DriverSetup();
		driver = setup.setupWebDriver();
	}
	
	@ParameterizedTest
	@CsvSource({"newUser, maniac, email@gmail.com"})
	public void testUserSignUp(String userName, String password, String name) {
		
		new HomePage()
		.accessURL(driver, "https://waesworks.bitbucket.io/")
		.accessSignUpPage(driver)
		.fillSignUpData(driver, userName, password)
		.confirmSignUp(driver)
		.verifyUserData(driver, name);
		
	}
	
	@AfterEach
	public void FinishTests() {
		setup.closeDriver(driver);
	}


}
