package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement getSearchBar(){
        return webDriver.findElement(By.id("search"));
    }

    public WebElement getSearchButton(){
        return webDriver.findElement(By.cssSelector("button[title='Search']"));
    }
}
