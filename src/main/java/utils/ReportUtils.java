package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportUtils {
    public static Scenario message;

    public static void takeScreenShot(String stepDetails) {
        byte[] screenshot = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.BYTES);
        message.attach(screenshot, "image/png", stepDetails);
    }
}
