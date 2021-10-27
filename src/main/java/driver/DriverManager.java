package driver;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverManager {
	private final static String CHROME_DRIVER_PATH = "./src/main/resources/chromedriver.exe";
	private final static int IMPLICIT_WAIT_TIMEOUT = 5;
	private final static int PAGE_LOAD_TIMEOUT = 20;
	private final static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

	private DriverManager() {
	}

	public static void setupDriver() {
		System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
		webDriverThreadLocal.set(driver);
	}

	public static WebDriver getDriver() {
		if (webDriverThreadLocal.get() == null) {
			setupDriver();
		}
		return webDriverThreadLocal.get();
	}

	public static void quitDriver() {
		Optional.ofNullable(getDriver()).ifPresent(webDriver -> {
			webDriver.quit();
			webDriverThreadLocal.remove();
		});
	}
}