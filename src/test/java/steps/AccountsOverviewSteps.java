package steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pages.AccountsOverviewPage;

public class AccountsOverviewSteps {
	private final AccountsOverviewPage accountsOverviewPage;

	public AccountsOverviewSteps() {
		this.accountsOverviewPage = new AccountsOverviewPage();
	}

	@Then("^verify user is navigated to 'Accounts Overview' page$")
	public void verifyUserIsNavigatedToAccountsOverviewPage() {
		Assert.assertTrue("User must be navigated to Accounts Overview Page",
				accountsOverviewPage.isDisplayed());
	}
}
