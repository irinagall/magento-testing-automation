package webtestframework.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import webtestframework.pages.Website;

import java.io.IOException;

public class RegistrationPageSteps {
    private Website website;

    public RegistrationPageSteps() {
        this.website = TestSetup.getWebsite("https://magento.softwaretestingboard.com/");
    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        TestSetup.startChromeService();
    }

    @AfterAll
    public static void afterAll(){
        TestSetup.stopChromeService();
    }

    @After
    public void afterEach(){
        TestSetup.quitWebDriver();
    }

    @Before
    public static void setup(){
        TestSetup.createWebDriver();
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
}
