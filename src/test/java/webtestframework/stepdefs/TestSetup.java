package webtestframework.stepdefs;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webtestframework.pages.Website;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestSetup {

    private static final String PROPERTIES_FILE_LOCATION = "src/test/resources/test.properties";
//    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver";
    private static ChromeDriverService service;
    private static WebDriver webDriver;
    private static Logger logger = LoggerFactory.getLogger(TestSetup.class);


    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        return options;
    }

    public static void startChromeService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(getDriverLocation()))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    public static void stopChromeService() {
        service.stop();
    }

    static void createWebDriver() {
        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
    }

    static void quitWebDriver() {
        try {
            webDriver.close();
        } catch (NoSuchSessionException e) {
            logger.warn("Unable to close web driver: {}", e.getMessage());
        }
    }

    public static String getDriverLocation() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(PROPERTIES_FILE_LOCATION));
        return properties.getProperty("driver.location");
    }

    static Website getWebsite(String url) {
        webDriver.get(url);
        return new Website(webDriver);
    }
}
