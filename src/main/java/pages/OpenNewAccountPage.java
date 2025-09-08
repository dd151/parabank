package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccountPage extends Page {

    private final String OPEN_NEW_ACCOUNT_PAGE_URL = "https://parabank.parasoft.com/parabank/openaccount.htm";
    @FindBy(id = "type")
    private WebElement accountType;
    @FindBy(id = "fromAccountId")
    private WebElement fromAccountId;
    @FindBy(css = "input[value='Open New Account']")
    private WebElement openNewAccount;
    @FindBy(id = "newAccountId")
    private WebElement newAccountId;
    @FindBy(id = "openAccountResult")
    private WebElement openAccountResult;

    public OpenNewAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        return true;
    }

    public OpenNewAccountPage open() {
        navigateTo(OPEN_NEW_ACCOUNT_PAGE_URL);
        return this;
    }

    public OpenNewAccountPage selectAccountType(String accountType) {
        selectDropdownByText(this.accountType, accountType);
        return this;
    }

    public OpenNewAccountPage selectFromAccountId(String accountId) {
        if (accountId.isEmpty()) {
            selectDropdownByIndex(this.fromAccountId, 0);
        } else {
            selectDropdownByText(this.fromAccountId, accountId);
        }
        return this;
    }

    public OpenNewAccountPage openNewAccount() {
        click(openNewAccount);
        return this;
    }

    public String getOpenAccountResultHeader() {
        openAccountResult = waitForVisibility(openAccountResult, 5);
        return openAccountResult.findElement(By.tagName("h1")).getText();
    }

    public String getOpenAccountResultBody() {
        openAccountResult = waitForVisibility(openAccountResult, 5);
        return openAccountResult.findElement(By.tagName("p")).getText();
    }

    public String getNewAccountID() {
        return waitForVisibility(newAccountId, 5).getText();
    }

    public AccountActivityPage clickNewAccountID() {
        click(newAccountId);
        return new AccountActivityPage();
    }
}
