package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    protected boolean waitUntilAttributePresent(WebElement element, String attribute, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "textContent"));
    }

    protected WebElement waitForVisibility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected Boolean waitForTextToBePresent(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(driver -> !element.getText().isEmpty());
    }

    protected String getText(WebElement element) {
        element = waitForVisibility(element, Constants.SHORT_TIMEOUT_SECONDS);
        return element.getText();
    }

    protected void click(WebElement element) {
        element = waitToBeClickable(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(Duration.ofMillis(Constants.SHORT_TIMEOUT_MILLISECONDS)).click().perform();
    }


    protected WebElement waitForDropdownToBeReady(WebElement element, int seconds) {
        WebElement visibleEl = waitForVisibility(element, seconds);
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(d -> {
            List<WebElement> options = visibleEl.findElements(By.tagName("option"));
            return !options.isEmpty();
        });
        return visibleEl;
    }

    protected void selectDropdownByText(WebElement element, String value) {
        element = waitForDropdownToBeReady(element, Constants.SHORT_TIMEOUT_SECONDS);
        Select selectEl = new Select(waitToBeClickable(element));
        selectEl.selectByContainsVisibleText(value);
    }

    protected void selectDropdownByIndex(WebElement element, int index) {
        element = waitForDropdownToBeReady(element, Constants.SHORT_TIMEOUT_SECONDS);
        Select selectEl = new Select(waitToBeClickable(element));
        selectEl.selectByIndex(index);
    }

    protected List<WebElement> waitForAllElements(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
