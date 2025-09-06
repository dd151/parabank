package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Signing up is easy!')]")
    private WebElement signUpHeaderText;

    @FindBy(id = "customerForm")
    private WebElement customerForm;

    @FindBy(id = "customer.firstName")
    private WebElement firstNameInput;
    @FindBy(id = "customer.lastName")
    private WebElement lastNameInput;
    @FindBy(id = "customer.address.street")
    private WebElement addressInput;
    @FindBy(id = "customer.address.city")
    private WebElement cityInput;
    @FindBy(id = "customer.address.state")
    private WebElement stateInput;
    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCodeInput;
    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumberInput;
    @FindBy(id = "customer.ssn")
    private WebElement ssnInput;

    @FindBy(id = "customer.username")
    private WebElement usernameInput;
    @FindBy(id = "customer.password")
    private WebElement passwordInput;
    @FindBy(id = "repeatedPassword")
    private WebElement repeatPasswordInput;
    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerButton;

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        return waitForVisibility(signUpHeaderText, 5).isDisplayed();
    }

    public RegistrationPage enterInputs(String firstName, String lastName, String address, String city, String state,
                                        String zipCode, String phone, String ssn, String username, String password, String repeatPassword) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(addressInput, address);
        type(cityInput, city);
        type(stateInput, state);
        type(zipCodeInput, zipCode);
        type(phoneNumberInput, phone);
        type(ssnInput, ssn);
        type(usernameInput, username);
        type(passwordInput, password);
        type(repeatPasswordInput, repeatPassword);
        return this;
    }

    public WelcomePage clickRegister() {
        click(registerButton);
        return new WelcomePage();
    }

    public List<String> getInputs() {
        return customerForm.findElements(By.xpath("//input[@class='input']//parent::td//preceding-sibling::td//b"))
                .stream().map(e -> e.getText().trim().replace(":", "")).toList();
    }

}
