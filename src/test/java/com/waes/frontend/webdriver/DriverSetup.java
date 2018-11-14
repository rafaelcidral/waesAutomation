package com.waes.frontend.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.waes.frontend.pageObjects.home.HomePage;

public class DriverSetup {
	
	public WebDriver driver;
	
	public WebDriver setupWebDriver() {
		
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		return driver;
	}
	

	
	public void closeDriver(WebDriver driver) {
		
		driver.close();		

	}

}
