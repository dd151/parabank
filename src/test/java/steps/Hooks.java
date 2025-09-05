package steps;

import enums.ReportStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverUtils;

public class Hooks {

	@Before(order = 1)
	public void setUp(Scenario scenario) {
		DriverUtils.initDriver("chrome");
	}

	@After
	public void tearDown(Scenario scenario) {
		DriverUtils.killDriver();
	}
}
