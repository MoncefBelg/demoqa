package Steps;

import Utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class datePicker {

    @When("user browse to the website")
    public void userBrowseToTheWebsite() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/temp/chrome-profile-" + System.currentTimeMillis());
        WebDriver driver = new ChromeDriver(options);


        driver.get("https://demoqa.com/");

    }

    @When("user clicks on Widget Icon")
    public void user_clicks_on_widget_icon() {



    }
    @When("use clicks on Date Picker Icon")
    public void use_clicks_on_date_picker_icon() {


    }
    @Then("user should be able to pick any date as preferred")
    public void user_should_be_able_to_pick_any_date_as_preferred() {



    }


}
