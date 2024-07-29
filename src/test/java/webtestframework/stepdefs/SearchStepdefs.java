package webtestframework.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import webtestframework.pages.SearchResultPage;
import webtestframework.pages.Website;

import java.io.IOException;

public class SearchStepdefs {

    private Website website;
    private static final String BASE_URL = "https://magento.softwaretestingboard.com/";

    @BeforeAll
    public static void beforeAll() throws IOException {
        TestSetup.startChromeService();
    }

    @AfterAll
    public static void afterAll() throws IOException {
        TestSetup.stopChromeService();
    }

    @After
    public void after() {
        TestSetup.quitWebDriver();
    }

    @Before
    public void before() {
        TestSetup.createWebDriver();
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        website = TestSetup.getWebsite(BASE_URL);
    }

    @When("I type in {string} to the search bar")
    public void iTypeInToTheSearchBar(String query) {
        WebElement searchBar = website.getSearchBar();
        searchBar.sendKeys(query);
    }

    @And("clicked the search button")
    public void clickedTheSearchButton() {
        WebElement searchButton = website.getSearchButton();
        searchButton.click();
    }

    @Then("the first item returned should be {string}")
    public void theFirstItemReturnedShouldBe(String productName) {
        SearchResultPage searchResultPage = new SearchResultPage(website.getWebDriver());
        Assertions.assertEquals(productName, searchResultPage.getFirstResult());
    }
}
