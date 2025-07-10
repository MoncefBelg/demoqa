package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt",
        glue = "Steps",
        tags = "@nestedIframes",
        monochrome = true,
        dryRun = false,
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json",
                }
)

public class FailedTestRerunRunner {
}
