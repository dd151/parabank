package steps;

import enums.ReportStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AccountsOverviewPage;
import pages.LoginPage;

public class LoginSteps {

	private final LoginPage loginPage;
	private AccountsOverviewPage accountsOverviewPage;

	public LoginSteps() {
		this.loginPage = new LoginPage();
	}

	@Given("user navigates to landing page")
	public void userNavigatesToLandingPage() {
		loginPage.navigateToLogin();
	}

	@When("^user logs in with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userLogsInWithAnd(String username, String password) {
		accountsOverviewPage = loginPage.enterInputs(username, password).clickLogin();
	}
}
