package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver webDriver;
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean areFormFieldsVisible() {
        return webDriver.findElement(firstNameField).isDisplayed() &&
                webDriver.findElement(lastNameField).isDisplayed() &&
                webDriver.findElement(emailField).isDisplayed() &&
                webDriver.findElement(passwordField).isDisplayed() &&
                webDriver.findElement(confirmPasswordField).isDisplayed();
    }
}
