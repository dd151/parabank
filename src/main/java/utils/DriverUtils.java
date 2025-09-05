package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {

	public static WebDriver driver;

	public static void initDriver(String browserName) {
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-extensions");
			options.addArguments("ignore-certificate-errors");
			options.addArguments("--window-size=1920,1080");
//			if (System.getProperty("headless").equalsIgnoreCase("true")) {
//				options.addArguments("--headless=new");
//				options.addArguments("--disable-gpu");
//			}
			driver = new ChromeDriver(options);
		}
		DriverUtils.driver = driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
