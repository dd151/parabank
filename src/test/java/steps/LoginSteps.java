package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AccountsOverviewPage;
import pages.LoginPage;
import utils.ReportUtils;

public class LoginSteps {

	private final LoginPage loginPage;
	private AccountsOverviewPage accountsOverviewPage;

	public LoginSteps() {
		this.loginPage = new LoginPage();
	}

	@Given("user navigates to landing page")
	public void userNavigatesToLandingPage() {
		loginPage.navigateToLogin();
        ReportUtils.takeScreenShot("User is in landing page");
	}

	@When("^user logs in with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userLogsInWithAnd(String username, String password) {
		accountsOverviewPage = loginPage.enterInputs(username, password).clickLogin();
        ReportUtils.takeScreenShot("User logs in with credentials");
	}
}
