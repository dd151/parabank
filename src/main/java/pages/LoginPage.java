package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

	@FindBy(linkText = "Register")
	private WebElement registerLink;
	@FindBy(css = "input[name='username']")
	private WebElement usernameInput;
	@FindBy(css = "input[name='password']")
	private WebElement passwordInput;
	@FindBy(css = "input[value='Log In']")
	private WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage navigateToLogin() {
		navigateTo("https://parabank.parasoft.com/parabank");
		return this;
	}

	public RegistrationPage clickRegister() {
		click(registerLink);
		return new RegistrationPage();
	}

	public LoginPage enterInputs(String username, String password) {
		type(usernameInput, username);
		type(passwordInput, password);
		return this;
	}

	public AccountsOverviewPage clickLogin() {
		click(loginButton);
		return new AccountsOverviewPage();
	}

}
