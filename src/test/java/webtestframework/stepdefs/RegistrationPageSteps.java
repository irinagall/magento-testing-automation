package webtestframework.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import webtestframework.pages.Website;

import java.io.IOException;

public class RegistrationPageSteps {
    private Website website;

  

    @BeforeAll
    public static void beforeAll() throws IOException {
        TestSetup.startChromeService();
    }

    @AfterAll
    public static void afterAll(){
        TestSetup.stopChromeService();
    }

    @Before
    public void setup(){
        TestSetup.createWebDriver();
        this.website = TestSetup.getWebsite("https://magento.softwaretestingboard.com/");
    }

    @After
    public void tearDown(){
        TestSetup.quitWebDriver();
    }


    @Given("I am on the registration form page")
    public void iAmOnTheRegistrationFormPage() {
        website.navigateToRegistrationPage();
        Assert.assertTrue("Not on registration page",
                website.getCurrentUrl().contains("/customer/account/create/"));
    }

    @Then("the form includes fields for first name, last name, email address, password, and password confirmation")
    public void theFormIncludesFieldsForFirstNameLastNameEmailAddressPasswordAndPasswordConfirmation() {
        Assert.assertTrue( website.getRegistrationPage().isFirstNameFieldPresent());
        Assert.assertTrue( website.getRegistrationPage().isLastNameFieldPresent());
        Assert.assertTrue( website.getRegistrationPage().isEmailFieldPresent());
        Assert.assertTrue(website.getRegistrationPage().isPasswordFieldPresent());
        Assert.assertTrue( website.getRegistrationPage().isConfirmPasswordFieldPresent());
    }



    @When("I enter {string} into the first name field")
    public void iEnterIntoTheFirstNameField(String firstName) {
        website.getRegistrationPage().setFirstName(firstName);
    }

    @And("I enter {string} into the last name field")
    public void iEnterIntoTheLastNameField(String lastName) {
        website.getRegistrationPage().setLastName(lastName);
    }

    @And("I enter {string} into the email field")
    public void iEnterIntoTheEmailField(String email) {
        website.getRegistrationPage().setEmail(email);
    }

    @And("I enter {string} into the password field")
    public void iEnterIntoThePasswordField(String password) {
        website.getRegistrationPage().setPassword(password);
    }

    @And("I enter {string} into the confirmation password field")
    public void iEnterIntoTheConfirmationPasswordField(String confirmPassword) {
        website.getRegistrationPage().setConfirmPassword(confirmPassword);
    }
    @When("I click the create account button")
    public void iClickTheCreateAccountButton() {
        website.getRegistrationPage().clickCreateAccountButton();
    }

    @Then("a message {string} will display")
    public void aMessageWillDisplay(String expectedMessage) {
        Assert.assertTrue("Password mismatch error message is not displayed",
                website.getRegistrationPage().isPasswordMismatchErrorDisplayed());
    }


}
