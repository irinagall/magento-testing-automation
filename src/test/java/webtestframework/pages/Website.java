package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Website {

    private WebDriver webDriver;
    private HomePage homePage;
    private BagsPage bagsPage;
    private ProductPage productPage;
    private ShippingDetailsPage shippingDetailsPage;
    private RegistrationPage registrationPage;
    private SearchResultPage searchResultPage;

    public Website(WebDriver driver) {
        this.webDriver = driver;
        homePage = new HomePage(driver);
        bagsPage = new BagsPage(driver);
        productPage = new ProductPage(driver);
        shippingDetailsPage = new ShippingDetailsPage(driver);
        registrationPage = new RegistrationPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public BagsPage getBagsPage() {
        return bagsPage;
    }

    public ProductPage getProductPage() {
        return productPage;
    }

    public ShippingDetailsPage getShippingDetailsPage() {
        return shippingDetailsPage;

    public SearchResultPage getSearchResultPage(){
        return searchResultPage;

    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
    }

    public void navigateToRegistrationPage() {
        webDriver.get("https://magento.softwaretestingboard.com/customer/account/create/");
      
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
