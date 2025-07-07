package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/Features/",
        glue = "Steps",
        tags = "@nestedIframes",
        monochrome = true,
        dryRun = true,
        plugin = {"pretty"}
)


public class RunnerClass {
}
