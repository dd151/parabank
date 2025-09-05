package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import enums.ReportStatus;

public class ReportUtils {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static String reportPath;

    private static void cleanPreviousReports() {
        try {
            // Delete old reports folder
            File reportsDir = new File(System.getProperty("user.dir") + "/reports");
            if (reportsDir.exists()) {
                FileUtils.cleanDirectory(reportsDir); // deletes all files inside
            }
            // Recreate screenshots folder
            File screenshotsDir = new File(System.getProperty("user.dir") + "/reports/screenshots");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	// Initialize ExtentReports once
	public static void initReports() {
		if (extent == null) {
            cleanPreviousReports();
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";
			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
			spark.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
	}

	// Create test entry for each test case
	public static void createTest(String testName) {
		ExtentTest extentTest = extent.createTest(testName);
		test.set(extentTest); // Thread-safe for parallel execution
	}

	// Log with screenshot
	public static void log(ReportStatus status, String message) {
		String screenshotPath = takeScreenshot();
		ExtentTest extentTest = test.get();

		if (extentTest == null) {
			throw new IllegalStateException("ExtentTest is not created. Call createTest() first.");
		}

		switch (status) {
		case PASS -> extentTest.pass(message).addScreenCaptureFromPath(screenshotPath);
		case FAIL -> extentTest.fail(message).addScreenCaptureFromPath(screenshotPath);
		case INFO -> extentTest.info(message).addScreenCaptureFromPath(screenshotPath);
		case WARNING -> extentTest.warning(message).addScreenCaptureFromPath(screenshotPath);
		}

		System.out.println("[" + status + "] " + message);
	}

	// Capture screenshot
	private static String takeScreenshot() {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path = System.getProperty("user.dir") + "/reports/screenshots/screenshot_" + timestamp + ".png";
		File srcFile = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	// Flush once at the end of suite
	public static void flushReports() {
		if (extent != null) {
			extent.flush();
		}
	}
}
