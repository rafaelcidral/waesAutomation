package com.waes.frontend.pageObjects.userProfile;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

import com.waes.frontend.pageObjects.userDetails.UserDetailsPage;
import com.waes.frontend.webdriver.DriverActions;


public class UserProfilePage extends DriverActions{
	
	public final String profileButtonId = "profile_link";	
	public final String loginButtonId = "login_link";
	public final String detailsButtonId = "details_link";
	
	
	public void verifyUserData(WebDriver driver, String name) {
	
		waitForElementVisibleById(driver, profileButtonId, 10);
		assertTrue(getTextById(driver, profileButtonId).contains("Profile"));

	}
	
	public void verifyInvalidUser(WebDriver driver, String name) {
		
		waitForElementVisibleById(driver, loginButtonId, 10);
		assertTrue(getTextById(driver, loginButtonId).contains("LogIn"));

	}
	
	public void verifyUserProfile(WebDriver driver, String name) {
		
		waitForElementVisibleByXPath(driver, "//*[contains(text(), '" + name + "')]", 10);
		assertTrue(getTextByPath(driver, "//*[contains(text(), '" + name + "')]").contains(name));

	}
	
	public UserDetailsPage accessDetailsPage(WebDriver driver) {
		
		clickById(driver, detailsButtonId);		
		return new UserDetailsPage();
		
	}
	

	

}
