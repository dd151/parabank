package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import org.junit.Assert;

import io.cucumber.java.en.Then;
import pages.AccountsOverviewPage;
import pages.grids.AccountsOverviewGrid;
import utils.ScenarioContext;

import java.util.Map;

public class AccountsOverviewSteps {
    private final ScenarioContext scenarioContext;
    private final AccountsOverviewPage accountsOverviewPage;

    public AccountsOverviewSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        this.accountsOverviewPage = new AccountsOverviewPage();
    }

    @Then("verify created account details are displayed:")
    public void verifyCreatedAccountDetailsAreDisplayed(DataTable dataTable) {
        Map<String, String> map = dataTable.asMaps().get(0);
        String expectedAccountNumber = map.get("Account Number") == null ? scenarioContext.get("newAccountNumber") : map.get("Account Number");
        String expectedBalance = map.get("Balance");
        String expectedAvailableAmount = map.get("Available Amount");

        AccountsOverviewGrid accountsOverviewGrid = accountsOverviewPage.getAccountsOverviewGrid();
        Assert.assertTrue(accountsOverviewGrid.getRowsCount() > 0);
        Assert.assertEquals(expectedAccountNumber, accountsOverviewGrid.getFieldByAccountNumber("Account Number", expectedAccountNumber));
        Assert.assertEquals(expectedBalance, accountsOverviewGrid.getFieldByAccountNumber("Balance", expectedAccountNumber));
        Assert.assertEquals(expectedAvailableAmount, accountsOverviewGrid.getFieldByAccountNumber("Available Amount", expectedAccountNumber));
    }

}
