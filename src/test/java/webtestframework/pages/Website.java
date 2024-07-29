package webtestframework.pages;

import org.openqa.selenium.WebDriver;

public class Website {

    private WebDriver webDriver;
    private HomePage homePage;
    private BagsPage bagsPage;
    private ProductPage productPage;
    private ShippingDetailsPage shippingDetailsPage;

    public Website(WebDriver driver) {
        this.webDriver = driver;
        homePage = new HomePage(driver);
        bagsPage = new BagsPage(driver);
        productPage = new ProductPage(driver);
        shippingDetailsPage = new ShippingDetailsPage(driver);
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
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }
}
