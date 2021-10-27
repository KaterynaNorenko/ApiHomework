package util;

import static driver.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverWaiters {

	public void waitUntilElementClickable(By locator) {
		new WebDriverWait(getDriver(), 15).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitUntilElementVisible(By locator, long timeout) {
		new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}