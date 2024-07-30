package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webtestframework.dto.ShippingDetailsDTO;

import java.time.Duration;

public class ShippingDetailsPage {

    private static final Logger logger = LoggerFactory.getLogger(ShippingDetailsPage.class);
    private final WebDriver webDriver;
    private final Wait<WebDriver> webDriverWait;
    private By emailAddressField = new By.ByCssSelector("#shipping #customer-email");
    private By firstNameField = new By.ByName("firstname");
    private By lastNameField = new By.ByName("lastname");
    private By companyField = new By.ByName("company");
    private By addressField = new By.ByName("street[0]");
    private By cityField = new By.ByName("city");
    private By regionField = new By.ByName("region_id");
    private By postcodeField = new By.ByName("postcode");
    private By phoneField = new By.ByName("telephone");
    private By fixedShippingRadio = new By.ByName("ko_unique_1");
    private By nextButton = new By.ByClassName("continue");
    private By stepTitle = new By.ByCssSelector("#shipping .step-title");

    public ShippingDetailsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public String getTitle() {
        webDriverWait.until(driver -> driver.findElement(stepTitle).isDisplayed());
        return webDriver.findElement(stepTitle).getText();
    }

    public void enterEmail(String email) {
        webDriverWait.until(driver -> driver.findElement(emailAddressField).isDisplayed());
        logger.info("Email field details: {}", webDriver.findElement(emailAddressField).getTagName());
        webDriver.findElement(emailAddressField).sendKeys(email);
    }

    public void enterFirstName(String firstName) {
        webDriver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        webDriver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterCompany(String company){
        webDriver.findElement(companyField).sendKeys(company);
    }

    public void enterAddress(String address) {
        webDriver.findElement(addressField).sendKeys(address);
    }

    public void enterCity(String city) {
        webDriver.findElement(cityField).sendKeys(city);
    }

    public void enterRegion(String region) {
        Select select = new Select(webDriver.findElement(regionField));
        select.selectByVisibleText(region);
    }

    public void enterPostcode(String postcode) {
        webDriver.findElement(postcodeField).sendKeys(postcode);
    }

    public void enterPhone(String phone) {
        webDriver.findElement(phoneField).sendKeys(phone);
    }

    public void selectFixedShipping() {
        webDriverWait.until(driver -> driver.findElement(fixedShippingRadio).isDisplayed());
        webDriver.findElement(fixedShippingRadio).click();
    }

    public void next() {
        webDriver.findElement(nextButton).click();
    }

    public void enterDetails(ShippingDetailsDTO details) {
        logger.info("Entering email: {}", details.email());
        enterEmail(details.email());
        logger.info("Entering first name: {}", details.firstName());
        enterFirstName(details.firstName());
        enterLastName(details.lastName());
        enterCompany(details.company());
        enterAddress(details.streetAddress());
        enterCity(details.city());
        enterRegion(details.state());
        enterPostcode(details.postalCode());
        enterPhone(details.phoneNumber());
    }


}
