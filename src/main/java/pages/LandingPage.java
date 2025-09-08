package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Page {

	@FindBy(linkText = "Register")
	private WebElement registerLink;
	@FindBy(css = "input[name='username']")
	private WebElement usernameInput;
	@FindBy(css = "input[name='password']")
	private WebElement passwordInput;
	@FindBy(css = "input[value='Log In']")
	private WebElement loginButton;

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	public LandingPage open() {
		navigateTo("https://parabank.parasoft.com/parabank");
		return this;
	}

	public RegistrationPage register() {
		click(registerLink);
		return new RegistrationPage();
	}

	public LandingPage enterInputs(String username, String password) {
		type(usernameInput, username);
		type(passwordInput, password);
		return this;
	}

	public AccountsOverviewPage login() {
		click(loginButton);
		return new AccountsOverviewPage();
	}

}
