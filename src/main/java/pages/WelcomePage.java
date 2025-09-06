package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends Page {

	@FindBy(className = "title")
	private WebElement welcomeTitle;
	private AccountServicesPage accountServicesPage;

	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isDisplayed() {
		return waitForVisibility(welcomeTitle, 5).isDisplayed();
	}

	public String getWelcomeTitle() {
		return welcomeTitle.getText();
	}

	public AccountServicesPage getAccountServicesPage() {
		return new AccountServicesPage();
	}
}
