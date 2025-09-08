package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.OpenNewAccountPage;
import utils.DateUtils;
import utils.ReportUtils;
import utils.ScenarioContext;

public class OpenNewAccountSteps {
    private final ScenarioContext scenarioContext;
    private OpenNewAccountPage openNewAccountPage;

    public OpenNewAccountSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        this.openNewAccountPage = new OpenNewAccountPage();
    }

    @And("user opens new account with {string} and {string}")
    public void userOpensNewAccountWithAnd(String accountType, String existingAccountNumber) {
        openNewAccountPage.selectAccountType(accountType)
                .selectFromAccountId(existingAccountNumber)
                .openNewAccount();
        scenarioContext.set("accountOpeningDate", DateUtils.getCurrentDate());
        ReportUtils.takeScreenShot("User opens new account.");
    }

    @Then("verify a new account is created successfully with account number")
    public void verifyANewAccountIsCreatedSuccessfullyWithAccountNumber() {
        Assert.assertEquals("Account Opened!", openNewAccountPage.getOpenAccountResultHeader());
        Assert.assertEquals("Congratulations, your account is now open.", openNewAccountPage.getOpenAccountResultBody());
        scenarioContext.set("newAccountNumber", openNewAccountPage.getNewAccountID());
        ReportUtils.takeScreenShot("New Account is created successfully with account number");
    }

    @And("user clicks on the created account number")
    public void userClicksOnTheCreatedAccountNumber() {
        openNewAccountPage.clickNewAccountID();
        ReportUtils.takeScreenShot("User clicks on created account number");
    }
}
