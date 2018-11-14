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
public class UserLoginTest {
	
	static WebDriver driver; 
	static DriverSetup setup;
	
	@BeforeEach
	public void Initialize() {
		setup = new DriverSetup();
		driver = setup.setupWebDriver();
	}
	
	@ParameterizedTest
	@CsvSource({ 
		"tester, maniac, Tester",
		"admin, hero, Amazing Admin", 
		"dev, wizard, Dev"})
	public void testUserLogin(String userName, String password, String name) {
		
		new HomePage()
		.accessURL(driver, "https://waesworks.bitbucket.io/")
		.accessLoginPage(driver)
		.fillUserData(driver, userName, password) 
		.confirmLogin(driver)
		.verifyUserData(driver, name);
		
	}
	
	@ParameterizedTest
	@CsvSource({ 
		"invalidUser, InvalidPassword, Wrong credentials"})
	public void testUserLoginInvalidUser(String userName, String password, String name) {
		
		new HomePage()
		.accessURL(driver, "https://waesworks.bitbucket.io/")
		.accessLoginPage(driver)
		.fillUserData(driver, userName, password) 
		.confirmLogin(driver)
		.verifyInvalidUser(driver, name);
		
	}
	
	@AfterEach
	public void FinishTests() {
		setup.closeDriver(driver);
	}

}
