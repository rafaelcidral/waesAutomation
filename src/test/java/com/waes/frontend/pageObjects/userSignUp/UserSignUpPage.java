package com.waes.frontend.pageObjects.userSignUp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.waes.frontend.pageObjects.userLogin.UserLoginPage;
import com.waes.frontend.pageObjects.userProfile.UserProfilePage;
import com.waes.frontend.webdriver.DriverActions;

public class UserSignUpPage extends DriverActions{
	
	public final String userNameId = "username_input";
	public final String passwordId = "password_input";
	public final String nameId = "name_input";
	public final String emailId = "email_input";
	public final String dayId = "day_select";
	public final String monthId = "month_select";
	public final String yearId = "year_select";
	public final String userName = "New User";
	public final String password = "password_input";
	public final String name = "New User";
	public final String email = "email@gmail.com";
	public final String submitButtonId = "submit_button";
	
	public UserSignUpPage fillSignUpData(WebDriver driver, String userName, String password) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		
		waitForElementVisibleById(driver, userNameId, 30);
		sendKeysById(driver, userNameId, userName + dateFormat.format(date));
		sendKeysById(driver, passwordId, password);
		sendKeysById(driver, nameId, name);
		sendKeysById(driver, emailId, email);
		selectById(driver, dayId, "15");
		selectById(driver, monthId, "April");
		selectById(driver, yearId, "2001");
		
		return this;
		
	}
	
	public UserProfilePage confirmSignUp(WebDriver driver) {
		
		clickById(driver, submitButtonId);
		
		return new UserProfilePage();
		
	}

}
