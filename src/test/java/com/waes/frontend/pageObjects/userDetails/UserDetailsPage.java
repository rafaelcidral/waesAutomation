package com.waes.frontend.pageObjects.userDetails;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.waes.frontend.webdriver.DriverActions;

public class UserDetailsPage extends DriverActions{
	
	public final String profileButtonId = "profile_link";	
	public final String loginButtonId = "login_link";
	
	
	public void verifyUserDetails(WebDriver driver, String name) {
		
		waitForElementVisibleByXPath(driver, "//*[contains(text(), '" + name + "')]", 10);
		assertTrue(getTextByPath(driver, "//*[contains(text(), '" + name + "')]").contains(name));

	}
}
