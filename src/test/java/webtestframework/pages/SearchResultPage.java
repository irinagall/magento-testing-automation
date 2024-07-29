package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
    private WebDriver webDriver;

    public SearchResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getFirstResult(){
        WebElement firstResult = webDriver.findElements(By.className("product-item-link")).getFirst();
        return firstResult.getText();
    }
}
