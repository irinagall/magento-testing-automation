package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    private final WebDriver webDriver;
    private By stepTitle = new By.ByCssSelector(".payment-group .step-title");

    public PaymentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getTitle() {
        return webDriver.findElement(stepTitle).getText();
    }
}
