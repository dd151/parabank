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
			options.addArguments("--window-size=1920,1080");
			options.addArguments("start-maximized");
			options.addArguments("disable-extensions");
			options.addArguments("ignore-certificate-errors");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--user-data-dir=/tmp/chrome-" + UUID.randomUUID());

			if (System.getProperty("headless") != null) {
				options.addArguments("--headless=new");
				options.addArguments("--disable-gpu");
			}
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
