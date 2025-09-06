package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.grids.AccountActivityGrid;

public class AccountActivityPage extends Page {
    @FindBy(id = "accountActivity")
    private WebElement accountActivity;
    @FindBy(id = "accountId")
    private WebElement accountID;
    @FindBy(id = "accountType")
    private WebElement accountType;
    @FindBy(id = "balance")
    private WebElement accountBalance;
    @FindBy(id = "availableBalance")
    private WebElement accountAvailableBalance;
    @FindBy(id = "month")
    private WebElement activityMonth;
    @FindBy(id = "transactionType")
    private WebElement activityType;
    @FindBy(css = "input[value='Go']")
    private WebElement go;

    private AccountActivityGrid activityGrid;

    public AccountActivityPage() {
        PageFactory.initElements(driver, this);
        this.activityGrid = new AccountActivityGrid();
    }

    public boolean isDisplayed() {
        return waitForVisibility(accountActivity, 5).isDisplayed();
    }

    public String getAccountID() {
        waitForTextToBePresent(accountID, 3);
        return getText(accountID);
    }

    public String getAccountType() {
        waitForTextToBePresent(accountType, 3);
        return getText(accountType);
    }

    public String getAccountBalance() {
        waitForTextToBePresent(accountBalance, 3);
        return getText(accountBalance);
    }

    public String getAccountAvailableBalance() {
        waitForTextToBePresent(accountAvailableBalance, 3);
        return getText(accountAvailableBalance);
    }

    public AccountActivityPage findActivities(String activityMonth, String activityType) {
        selectDropdownByText(this.activityMonth, activityMonth.isEmpty() ? "All" : activityMonth);
        selectDropdownByText(this.activityType, activityType.isEmpty() ? "All" : activityType);
        click(go);
        return this;
    }

    public AccountActivityGrid getAccountActivityGrid() {
        return this.activityGrid;
    }

}
