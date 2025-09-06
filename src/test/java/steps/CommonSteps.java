package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;

public class CommonSteps {

    @Then("verify user is navigated to {string} page")
    public void verifyUserIsNavigatedToAccountsOverviewPage(String pageName) {
        if (pageName.equalsIgnoreCase("Welcome")) {
            Assert.assertTrue("User must be navigated to Welcome Page", new WelcomePage().isDisplayed());
        } else if (pageName.equalsIgnoreCase("Accounts Overview")) {
            Assert.assertTrue("User must be navigated to Accounts Overview Page", new AccountsOverviewPage().isDisplayed());
        } else if (pageName.equalsIgnoreCase("Open New Account")) {
            Assert.assertTrue("User must be navigated to Open New Account Page", new OpenNewAccountPage().isDisplayed());
        } else if (pageName.equalsIgnoreCase("Account Activity")) {
            Assert.assertTrue("User must be navigated to Account Overview Page", new AccountActivityPage().isDisplayed());
        } else if (pageName.equalsIgnoreCase("Registration")) {
            Assert.assertTrue("User must be navigated to Registration Page", new RegistrationPage().isDisplayed());
        } else {
            throw new IllegalArgumentException("Page name not found: " + pageName);
        }
    }

    @When("user navigates to {string} page")
    public void userNavigatesToPage(String pageName) {
        if (pageName.equalsIgnoreCase("Open New Account")) {
            new OpenNewAccountPage().navigateToPage();
        } else if (pageName.equalsIgnoreCase("Accounts Overview")) {
            new AccountsOverviewPage().navigateToPage();
        } else {
            throw new IllegalArgumentException("Page name not found: " + pageName);
        }
    }
}
