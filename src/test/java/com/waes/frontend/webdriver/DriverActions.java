package com.waes.frontend.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverActions {
	
	
	public void clickById(WebDriver driver, String locator) {
		driver.findElement(By.id(locator)).click();
	}
	
	public void clickByName(WebDriver driver, String locator) {
		driver.findElement(By.name(locator)).click();
	}
	
	public void clickByPath(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	
	public void clickByPartialLinkText(WebDriver driver, String locator) {
		driver.findElement(By.partialLinkText(locator)).click();
	}
	
	public void clickByClassName(WebDriver driver, String locator) {
		driver.findElement(By.className(locator)).click();
	}
	
	public void clickByCssSelector(WebDriver driver, String locator) {
		driver.findElement(By.cssSelector(locator)).click();
	}	
	
	public void sendKeysById(WebDriver driver, String locator, String text) {
		driver.findElement(By.id(locator)).sendKeys(text);
	}
	
	public void sendKeysByName(WebDriver driver, String locator, String text) {
		driver.findElement(By.name(locator)).sendKeys(text);
	}
	
	public void sendKeysByPath(WebDriver driver, String locator, String text) {
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public void sendKeysByPartialLinkText(WebDriver driver, String locator, String text) {
		driver.findElement(By.partialLinkText(locator)).sendKeys(text);
	}
	
	public void sendKeysByClassName(WebDriver driver, String locator, String text) {
		driver.findElement(By.className(locator)).sendKeys(text);
	}
	
	public void sendKeysByCssSelector(WebDriver driver, String locator, String text) {
		driver.findElement(By.cssSelector(locator)).sendKeys(text);
	}
	
	public String getTextById(WebDriver driver, String locator) {
		return driver.findElement(By.id(locator)).getText();
	}
	
	public String getTextByName(WebDriver driver, String locator) {
		return driver.findElement(By.name(locator)).getText();
	}
	
	public String getTextByPath(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator)).getText();
	}
	
	public String getTextByPartialLinkText(WebDriver driver, String locator) {
		return driver.findElement(By.partialLinkText(locator)).getText();
	}
	
	public String getTextByClassName(WebDriver driver, String locator) {
		return driver.findElement(By.className(locator)).getText();
	}
	
	public String getTextByCssSelector(WebDriver driver, String locator) {
		return driver.findElement(By.cssSelector(locator)).getText();
	}
	
	public void waitForElementVisibleById(WebDriver driver, String locator, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		
	}
	
	public void waitForElementVisibleByXPath(WebDriver driver, String locator, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		
	}
	
	public void selectById(WebDriver driver, String locator, String text) {
		Select dropdown = new Select(driver.findElement(By.id(locator)));
		dropdown.selectByVisibleText(text);
	}
	
	public void selectByName(WebDriver driver, String locator, String text) {
		Select dropdown = new Select(driver.findElement(By.name(locator)));
		dropdown.selectByVisibleText(text);
	}
	
	public void selectByPath(WebDriver driver, String locator, String text) {
		Select dropdown = new Select(driver.findElement(By.xpath(locator)));
		dropdown.selectByVisibleText(text);
	}
	
	public void selectByPartialLinkText(WebDriver driver, String locator, String text) {
		Select dropdown = new Select(driver.findElement(By.partialLinkText(locator)));
		dropdown.selectByVisibleText(text);
	}
	

	
	
}
