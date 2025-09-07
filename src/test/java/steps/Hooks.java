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
		DriverUtils.initDriver(System.getProperty("browser"));
        ReportUtils.message = scenario;
    }

	@After
	public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            ReportUtils.takeScreenShot("Scenario Failed.");
        }
		DriverUtils.killDriver();
	}
}
