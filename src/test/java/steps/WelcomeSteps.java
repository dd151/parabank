package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.WelcomePage;
import utils.ReportUtils;

public class WelcomeSteps {

	private final WelcomePage welcomePage;

	public WelcomeSteps() {
		this.welcomePage = new WelcomePage();
	}

	@And("^verify welcome title \"([^\"]*)\" is displayed in 'Welcome' page$")
	public void verifyWelcomeTitleIsDisplayedInWelcomePage(String title) {
		Assert.assertEquals("Welcome title should be : " + title, title, welcomePage.getWelcomeTitle());
        ReportUtils.takeScreenShot("Welcome title is displayed.");
	}
}
