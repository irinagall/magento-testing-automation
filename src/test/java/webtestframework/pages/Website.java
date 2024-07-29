package webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Website {

    private WebDriver webDriver;
    private HomePage homePage;
    private SearchResultPage searchResultPage;

    public Website(WebDriver driver) {
        this.webDriver = driver;
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public SearchResultPage getSearchResultPage(){
        return searchResultPage;
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
}
