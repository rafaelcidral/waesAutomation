package com.waes.frontend.pageObjects.home;

import org.openqa.selenium.WebDriver;

import com.waes.frontend.pageObjects.userDetails.UserDetailsPage;
import com.waes.frontend.pageObjects.userLogin.UserLoginPage;
import com.waes.frontend.pageObjects.userSignUp.UserSignUpPage;
import com.waes.frontend.webdriver.DriverActions;

public class HomePage extends DriverActions{
	
	public final String loginButton = "login_link";
	public final String signUpButton = "signup_link";
	
	public HomePage accessURL(WebDriver driver, String url) {
		
		driver.get(url);		
		return this;
		
	}
	
	public UserLoginPage accessLoginPage(WebDriver driver) {
		
		clickById(driver, loginButton);		
		return new UserLoginPage();
		
	}
	
	public UserSignUpPage accessSignUpPage(WebDriver driver) {
		
		clickById(driver, signUpButton);		
		return new UserSignUpPage();
		
	}
	


}
