package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final WebDriver webDriver;
    private Wait<WebDriver> webDriverWait;

    private By productName = new By.ByCssSelector(".page-title > span");
    private By addToCartButton = new By.ById("product-addtocart-button");
    private By successMessage = new By.ByCssSelector("message-success > div");
    private By cartCounter = new By.ByClassName("counter-number");

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public String getProductName() {
        return webDriver.findElement(productName).getText();
    }

    public void addToCart() {
        webDriver.findElement(addToCartButton).click();
    }

    public String getSuccessMessage() {
        try {
            webDriverWait.until(driver -> driver.findElement(successMessage).isDisplayed());
            return webDriver.findElement(successMessage).getText();
        } catch(NoSuchElementException e) {
            return "";
        }
    }

    public int getCartCount() {
        try {
            webDriverWait.until(driver -> {
                String cartCount = driver.findElement(cartCounter)
                                         .getText();
                return !cartCount.equals("0") && !cartCount.isEmpty();
            });
            return Integer.parseInt(webDriver.findElement(cartCounter).getText());
        } catch (NoSuchElementException | NumberFormatException e) {
            throw new RuntimeException("Did not find the element or the number was not formatted correctly");
        }
    }
}
