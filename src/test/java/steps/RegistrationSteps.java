package steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.LandingPage;
import pages.RegistrationPage;
import pages.WelcomePage;
import utils.ReportUtils;

public class RegistrationSteps {

	private RegistrationPage registrationPage;
	private final LandingPage landingPage;
	private WelcomePage welcomePage;

	public RegistrationSteps() {
		this.landingPage = new LandingPage();
	}

	@When("user clicks on 'Register' link")
	public void clickRegisterLink() {
		registrationPage = landingPage.register();
        ReportUtils.takeScreenShot("User clicks on Register link");
	}

	@And("verify the registration form is displayed with fields:")
	public void registrationFormIsDisplayedWithFields(List<String> expectedList) {
		Assert.assertEquals("Registration form input fields must match the expected list", expectedList,
				registrationPage.getInputs());
        ReportUtils.takeScreenShot("Registration form is displayed with fields");
	}

	@And("^user enters registeration details:$")
	public void userEntersEntersRegisterationDetails(Map<String, String> inputMap) {
		String firstName = inputMap.get("First Name");
		String lastName = inputMap.get("Last Name");
		String address = inputMap.get("Address");
		String city = inputMap.get("City");
		String state = inputMap.get("State");
		String zipCode = inputMap.get("Zip Code");
		String phone = inputMap.get("Phone #");
		String ssn = inputMap.get("SSN");
		String userName = inputMap.get("Username");
		String password = inputMap.get("Password");
		String confirmPassword = inputMap.get("Confirm");
		registrationPage.enterInputs(firstName, lastName, address, city, state, zipCode, phone, ssn, userName, password,
				confirmPassword);
        ReportUtils.takeScreenShot("Registration form is displayed with fields");
	}

	@And("^user clicks on 'Register' button$")
	public void userClicksOnRegisterButton() {
		welcomePage = registrationPage.register();
        ReportUtils.takeScreenShot("User clicks on Register button");
	}
}
