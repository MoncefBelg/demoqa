package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/Features/",
        glue = "Steps",
        tags = "@regression",
        monochrome = true,
        dryRun = false,
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json",
                "rerun:target/failed.txt"}
)


public class ClassRunner  {


}
