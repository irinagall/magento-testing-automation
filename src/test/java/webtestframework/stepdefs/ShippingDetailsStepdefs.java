package webtestframework.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import webtestframework.dto.ShippingDetailsDTO;
import webtestframework.pages.Website;

import java.util.List;

import static org.hamcrest.Matchers.*;

public class ShippingDetailsStepdefs {

    private static final String PRODUCT_PAGE_URL = "https://magento.softwaretestingboard.com/push-it-messenger-bag.html";
    private Website website;

    private ShippingDetailsDTO shippingDetails;

    @Given("I have added an item to my cart")
    public void iHaveAAddedAnItemToMyCart() {
        website = TestSetup.getWebsite(PRODUCT_PAGE_URL);
        website.getProductPage().addToCart();
    }

    @When("I click to proceed to checkout")
    public void iClickToProceedToCheckout() {
        website.getProductPage().openCart();
        website.getProductPage().checkout();
    }

    @Then("I am redirected to the shipping details page")
    public void iAmRedirectedToTheShippingDetailsPage() {
        MatcherAssert.assertThat(website.getShippingDetailsPage().getTitle(), is("Shipping Address"));
    }

    @And("I have proceeded to the shipping details form")
    public void iHaveProceededToTheShippingDetailsForm() {
        website.getProductPage().openCart();
        website.getProductPage().checkout();
    }



    @And("I select a fixed shipping method")
    public void iSelectAFixedShippingMethod() {
        website.getShippingDetailsPage().selectFixedShipping();
    }

    @And("I click next")
    public void iClickNext() {
        website.getShippingDetailsPage().next();
    }

    @Then("I am taken to the payment page")
    public void iAmTakenToThePaymentPage() {
        MatcherAssert.assertThat(website.getPaymentPage().getTitle(), is("Payment Method"));
    }

    @When("I enter the following shipping address")
    public void iEnterTheFollowingShippingAddress(DataTable dataTable) {
        List<List<String>> details = dataTable.asLists(String.class);
        shippingDetails = ShippingDetailsDTO.fromTableRow(details.getFirst());
        website.getShippingDetailsPage().enterDetails(shippingDetails);
    }
}
