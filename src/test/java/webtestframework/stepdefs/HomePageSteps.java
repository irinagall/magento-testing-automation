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
import org.junit.Test;
import webtestframework.pages.Website;

import java.io.IOException;

public class HomePageSteps {
    private Website website;

    @BeforeAll
    public static void beforeAll() throws IOException{
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

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        website = TestSetup.getWebsite("https://magento.softwaretestingboard.com/");
        Assert.assertEquals("Expected URL doesn't match",
                "https://magento.softwaretestingboard.com/", website.getCurrentUrl());
    }

    @Then("the {string} link is visible in the top right corner")
    public void theLinkIsVisibleInTheTopRightCorner(String linkText) {
        Assert.assertTrue("Create an Account link is not visible",
                website.getHomePage().isCreateAccountLinkVisible());
        Assert.assertEquals("Link text doesn't match", linkText,
                website.getHomePage().getCreateAccountLinkText());
    }

    @When("I click the {string} link")
    public void iClickTheLink(String linkText) {
        website.getHomePage().clickCreateAccountLink();
    }

    @Then("I am taken to the registration page")
    public void iAmTakenToTheRegistrationPage() {
        Assert.assertTrue("Not on registration page",
                website.getCurrentUrl().contains("/customer/account/create/"));
    }

    @And("the registration form fields are visible")
    public void theRegistrationFormFieldsAreVisible() {
        Assert.assertTrue("Registration form fields are not visible",
                website.getRegistrationPage().areFormFieldsVisible());
    }
}
