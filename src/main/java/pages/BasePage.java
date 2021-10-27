package pages;

import static driver.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.WebDriverWaiters;


public class BasePage extends WebDriverWaiters {

	public WebElement findElement(By by) {
		return getDriver().findElement(by);
	}

	public void waitForElementIsClickable(By by) {
		waitUntilElementClickable(by);
	}

	public void waitForElementIsVisible(By by) {
		waitUntilElementVisible(by, 10);
	}
}