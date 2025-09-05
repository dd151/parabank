package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountServicesPage extends Page {

	@FindBy(linkText = "Open New Account")
	private WebElement openNewAccountLink;

	@FindBy(linkText = "Accounts Overview")
	private WebElement accountsOverviewLink;

	@FindBy(linkText = "Transfer Funds")
	private WebElement transferFundsLink;

	@FindBy(linkText = "Bill Pay")
	private WebElement billPayLink;

	@FindBy(linkText = "Find Transactions")
	private WebElement findTransactionsLink;

	@FindBy(linkText = "Update Contact Info")
	private WebElement updateContactInfoLink;

	@FindBy(linkText = "Request Loan")
	private WebElement requestLoanLink;

	@FindBy(linkText = "Log Out")
	private WebElement logOutLink;

	public AccountServicesPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickLink(String link) {
		switch (link.toLowerCase()) {
		case "open new account":
			click(openNewAccountLink);
			break;
		case "accounts overview":
			click(accountsOverviewLink);
			break;
		case "transfer funds":
			click(transferFundsLink);
			break;
		case "bill pay":
			click(billPayLink);
			break;
		case "find transactions":
			click(findTransactionsLink);
			break;
		case "update contact info":
			click(updateContactInfoLink);
			break;
		case "request loan":
			click(requestLoanLink);
			break;
		case "log out":
			click(logOutLink);
			break;
		default:
			throw new IllegalArgumentException("Invalid link name: " + link);
		}
	}

}
