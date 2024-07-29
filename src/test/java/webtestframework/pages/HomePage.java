package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver webDriver;
    private By createAccountLink = By.linkText("Create an Account");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isCreateAccountLinkVisible() {
        return webDriver.findElement(createAccountLink).isDisplayed();
    }

    public String getCreateAccountLinkText() {
        return webDriver.findElement(createAccountLink).getText();
    }


    public void clickCreateAccountLink() {
        webDriver.findElement(createAccountLink).click();
    }
}
