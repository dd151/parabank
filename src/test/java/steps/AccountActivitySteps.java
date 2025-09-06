package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AccountActivityPage;
import pages.grids.AccountActivityGrid;
import utils.ScenarioContext;

import java.util.List;
import java.util.Map;

public class AccountActivitySteps {
    private final ScenarioContext scenarioContext;
    private AccountActivityPage accountActivityPage;

    public AccountActivitySteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        accountActivityPage = new AccountActivityPage();
    }

    @Then("verify the account details are displayed:")
    public void verifyTheAccountDetailsAreDisplayed(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMaps().get(0);
        String expectedAccountNumber = dataMap.get("Account Number") == null ? scenarioContext.get("newAccountNumber") : dataMap.get("Account Number");
        Assert.assertEquals(expectedAccountNumber, accountActivityPage.getAccountID());
        Assert.assertEquals(dataMap.get("Account Type"), accountActivityPage.getAccountType());
        Assert.assertEquals(dataMap.get("Balance"), accountActivityPage.getAccountBalance());
        Assert.assertEquals(dataMap.get("Available"), accountActivityPage.getAccountAvailableBalance());
    }

    @And("verify the account activity details are displayed:")
    public void verifyTheAccountActivityDetailsAreDisplayed(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> dataMaps = dataTable.asMaps();
        AccountActivityGrid activityGrid = accountActivityPage.getAccountActivityGrid();
        Assert.assertEquals(1, activityGrid.getRowsCount());
        for (int i = 0; i < dataMaps.size(); i++) {
            String expectedDate = dataMaps.get(i).get("Date") == null ? scenarioContext.get("accountOpeningDate") : dataMaps.get(i).get("Date");
            String expectedTransaction = dataMaps.get(i).get("Transaction");
            String expectedDebit = dataMaps.get(i).get("Debit") == null ? "" : dataMaps.get(i).get("Debit");
            String expectedCredit = dataMaps.get(i).get("Credit") == null ? "" : dataMaps.get(i).get("Credit");

            Assert.assertEquals(expectedDate, activityGrid.getFieldByIndex("Date", i + 1));
            Assert.assertEquals(expectedTransaction, activityGrid.getFieldByIndex("Transaction", i + 1));
            Assert.assertEquals(expectedDebit, activityGrid.getFieldByIndex("Debit", i + 1));
            Assert.assertEquals(expectedCredit, activityGrid.getFieldByIndex("Credit", i + 1));
        }

    }
}
