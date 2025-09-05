package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.WelcomePage;

public class WelcomeSteps {

	private WelcomePage welcomePage;

	public WelcomeSteps() {
		this.welcomePage = new WelcomePage();
	}

	@Then("verify user is navigated to 'Welcome' page")
	public void userNavigatedToWelcomePage() {
		Assert.assertTrue("User should be navigated to Welcome Page", welcomePage.isDisplayed());
	}

	@And("^verify welcome title \"([^\"]*)\" is displayed in 'Welcome' page$")
	public void verifyWelcomeTitleIsDisplayedInWelcomePage(String title) {
		Assert.assertEquals("Welcome title should be : " + title, title, welcomePage.getWelcomeTitle());
	}
}
