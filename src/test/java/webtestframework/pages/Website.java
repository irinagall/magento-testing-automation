package webtestframework.pages;

import org.openqa.selenium.WebDriver;

public class Website {

    private WebDriver webDriver;
    private HomePage homePage;
    private RegistrationPage registrationPage;

    public Website(WebDriver driver) {
        this.webDriver = driver;
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    public HomePage getHomePage() {
        return homePage;
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
    }
}
