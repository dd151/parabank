package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AccountsOverviewPage;
import pages.LandingPage;
import utils.ReportUtils;

public class LoginSteps {

	private final LandingPage landingPage;
	private AccountsOverviewPage accountsOverviewPage;

	public LoginSteps() {
		this.landingPage = new LandingPage();
	}

	@Given("user navigates to landing page")
	public void userNavigatesToLandingPage() {
		landingPage.open();
        ReportUtils.takeScreenShot("User is in landing page");
	}

	@When("^user logs in with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userLogsInWithAnd(String username, String password) {
		accountsOverviewPage = landingPage.enterInputs(username, password)
                .login();
        ReportUtils.takeScreenShot("User logs in with credentials");
	}
}
