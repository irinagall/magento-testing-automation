package webtestframework.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;
import webtestframework.pages.Website;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.List;

public class PurchaseStepdefs {

    private static final String BAGS_PAGE_URL = "https://magento.softwaretestingboard.com/gear/bags.html";
    private Website website;
    private List<WebElement> bagLinks;

    @BeforeAll
    public static void beforeAll() throws IOException {
        TestSetup.startChromeService();
    }

    @AfterAll
    public static void afterAll() {
        TestSetup.stopChromeService();
    }

    @After
    public void afterEach() {
        TestSetup.quitWebDriver();
    }

    @Before
    public static void setup() {
        TestSetup.createWebDriver();
    }

    @Given("I am on the Bags page")
    public void iAmOnTheBagsPage() {
        website = TestSetup.getWebsite(BAGS_PAGE_URL);
    }

    @Then("the count next to the cart icon increases by one")
    public void theCountNextToTheCartIconIncreasesByOne() {
        int count = website.getProductPage().getCartCount();
        MatcherAssert.assertThat(count, is(1));
    }

    @And("a confirmation message that says {string} is displayed")
    public void aConfirmationMessageThatSaysIsDisplayed(String expectedMessage) {
        MatcherAssert.assertThat(website.getProductPage().getSuccessMessage(), is(expectedMessage));
    }

    @When("I view the list of items shown")
    public void iViewTheListOfItemsShown() {
        bagLinks = website.getBagsPage()
                          .getBagLinks();
    }

    @Then("multiple items are displayed")
    public void multipleItemsAreDisplayed() {
        MatcherAssert.assertThat(bagLinks.size(), greaterThan(1));
    }

    @And("I click on the first item shown")
    public void iClickOnTheFirstItemShown() {
        bagLinks.getFirst().click();
    }

    @Then("I am redirected to the product page for {string}")
    public void iAmRedirectedToTheProductPageFor(String expectedProductName) {
        String productName = website.getProductPage().getProductName();
        MatcherAssert.assertThat(productName, is(expectedProductName));
    }

    @And("I click to add that item to the cart")
    public void iClickToAddThatItemToTheCart() {
        website.getProductPage().addToCart();
    }
}
