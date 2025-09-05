package steps;

import enums.ReportStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverUtils;
import utils.ReportUtils;

public class Hooks {

	@Before(order = 1)
	public void setUp(Scenario scenario) {
		DriverUtils.initDriver("chrome");
		ReportUtils.initReports();
		ReportUtils.createTest(scenario.getName());
		ReportUtils.log(ReportStatus.INFO, "Starting scenario: " + scenario.getName());
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			ReportUtils.log(ReportStatus.FAIL, "Scenario Failed: " + scenario.getName());
		} else {
			ReportUtils.log(ReportStatus.PASS, "Scenario Passed: " + scenario.getName());
		}
		ReportUtils.flushReports();
		DriverUtils.killDriver();
	}
}
