package com.waes.frontend.pageObjects.userLogin;

import org.openqa.selenium.WebDriver;

import com.waes.frontend.pageObjects.userProfile.UserProfilePage;
import com.waes.frontend.webdriver.DriverActions;

public class UserLoginPage extends DriverActions{
	
	public final String userNameId = "username_input";
	public final String passwordId = "password_input";
	public final String loginButtonId= "login_button";
	
	public UserLoginPage fillUserData(WebDriver driver, String userName, String password) {
		
		waitForElementVisibleById(driver, userNameId, 30);
		sendKeysById(driver, userNameId, userName);
		sendKeysById(driver, passwordId, password);
		
		return new UserLoginPage();
		
	}
	
	public UserProfilePage confirmLogin(WebDriver driver) {

		clickById(driver, loginButtonId);
		
		return new UserProfilePage();
		
	}
	
}
