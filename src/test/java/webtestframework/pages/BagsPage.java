package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BagsPage {

    private WebDriver webDriver;
    private By bagLinks = new By.ByClassName("product-item-photo");

    public BagsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public List<WebElement> getBagLinks() {
        return webDriver.findElements(bagLinks);
    }
}
