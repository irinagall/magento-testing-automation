import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import webtestframework.stepdefs.TestSetup;

import java.io.File;
import java.io.IOException;

public class Profiletest {

    private String BASE_URL = "https://magento.softwaretestingboard.com/";
    private static ChromeDriverService service;
    // ChromeDriver
    private WebDriver webDriver;

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
//        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        return options;
    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(TestSetup.getDriverLocation()))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterAll
    public static void afterAll() {
        service.stop();
    }

    @BeforeEach
    void setup() {
        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
    }

    @AfterEach
    void afterEach() {
        webDriver.close();
    }

    @Test
    @DisplayName("Check that the web driver works")
    void checkThatTheWebDriverWorks() {
        webDriver.get(BASE_URL);
        Assertions.assertEquals(BASE_URL, webDriver.getCurrentUrl());
        Assertions.assertEquals("Home Page", webDriver.getTitle());
    }
}
