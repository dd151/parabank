package utils;

import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--user-data-dir=/tmp/chrome-" + UUID.randomUUID());
            if (System.getProperty("headless") != null) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("-profile");
            options.addArguments("/tmp/firefox-" + UUID.randomUUID());
            if (System.getProperty("headless") != null) {
                options.addArguments("--headless");
            }
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("start-maximized");
            options.addArguments("disable-extensions");
            options.addArguments("ignore-certificate-errors");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--user-data-dir=/tmp/edge-" + UUID.randomUUID());
            if (System.getProperty("headless") != null) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
            }
            driver = new EdgeDriver(options);
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
