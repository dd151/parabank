package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Constants;
import utils.DriverUtils;

public abstract class Page {

	protected WebDriver driver;

	protected Page() {
		this.driver = DriverUtils.getDriver();
	}

	protected void navigateTo(String string) {
		driver.get(string);
	}

	protected void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	protected void type(WebElement element, String value) {
		scrollToElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().pause(Duration.ofMillis(Constants.SHORT_TIMEOUT_MILLISECONDS))
				.sendKeys(value).perform();
	}

	protected WebElement waitToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.SHORT_TIMEOUT_SECONDS));
		WebElement clickableEl = null;
		try {
			clickableEl = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
			System.out.println("Timed out waiting for the element to be clickable");
			e.printStackTrace();
		}
		return clickableEl;
	}

	protected boolean waitForVisibility(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			System.out.println("Timed out waiting for the element to be visible");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	protected void click(WebElement element) {
		element = waitToBeClickable(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).pause(Duration.ofMillis(Constants.SHORT_TIMEOUT_MILLISECONDS)).click().perform();
	}
}
