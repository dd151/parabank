package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverviewPage extends Page {

	@FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
	private WebElement accountsOverViewHeader;

	public AccountsOverviewPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isDisplayed() {
		return waitForVisibility(accountsOverViewHeader, 5);
	}

}
