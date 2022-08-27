package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-html-report"},
        features = "src/test/resources/features",
        glue = "stepdefinitions"
)
public class CucumberRunner {
}
