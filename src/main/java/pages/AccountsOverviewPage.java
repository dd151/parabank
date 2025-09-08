package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.grids.AccountsOverviewGrid;

public class AccountsOverviewPage extends Page {

    private final String ACCOUNTS_OVERVIEW_PAGE_URL = "https://parabank.parasoft.com/parabank/overview.htm";
    @FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
    private WebElement accountsOverViewHeader;
    @Getter
    private AccountsOverviewGrid accountsOverviewGrid;

    public AccountsOverviewPage() {
        PageFactory.initElements(driver, this);
        this.accountsOverviewGrid = new AccountsOverviewGrid();
    }

    public void open() {
        navigateTo(ACCOUNTS_OVERVIEW_PAGE_URL);
    }

    public boolean isAt() {
        return waitForVisibility(accountsOverViewHeader, 5).isDisplayed();
    }

}
