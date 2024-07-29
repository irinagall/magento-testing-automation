package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver webDriver;
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By passwordMismatchError =  By.cssSelector("password-confirmation-error.mage-error");

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

    public boolean isFirstNameFieldPresent() {
        return webDriver.findElement(firstNameField).isDisplayed();
    }

    public boolean isLastNameFieldPresent() {
        return webDriver.findElement(lastNameField).isDisplayed();
    }

    public boolean isEmailFieldPresent() {
        return webDriver.findElement(emailField).isDisplayed();
    }

    public boolean isPasswordFieldPresent() {
        return webDriver.findElement(passwordField).isDisplayed();
    }

    public boolean isConfirmPasswordFieldPresent() {
        return webDriver.findElement(confirmPasswordField).isDisplayed();
    }

    public void setPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        webDriver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public boolean isPasswordMismatchErrorDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-confirmation-error")));
            return errorElement.isDisplayed() && errorElement.getText().contains("Please enter the same value again.");
        } catch (Exception e) {
            return false;
        }
    }
}
