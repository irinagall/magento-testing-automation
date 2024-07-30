package webtestframework.stepdefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:reports/testReport.html", "json:reports/jsonReport.json"},
        publish = true
)
public class TestRunner {
}
