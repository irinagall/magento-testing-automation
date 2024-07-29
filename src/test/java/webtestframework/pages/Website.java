package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Website {

    private WebDriver webDriver;
    private HomePage homePage;

    public Website(WebDriver driver) {
        this.webDriver = driver;
        homePage = new HomePage(driver);
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

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement getSearchBar(){
        return webDriver.findElement(By.id("search"));
    }

    public WebElement getSearchButton(){
        return webDriver.findElement(By.cssSelector("button[title='Search']"));
    }
}
