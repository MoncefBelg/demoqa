package Steps;

import Pages.NestedFrames;
import Utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NestedIframes extends CommonMethods {


    @When("User clicks on the Alerts,Frame & Windows")
    public void user_clicks_on_the_alerts_frame_windows() {
      Click(nestedFrames.Alerts_Frame_Windows);
    }
    @When("User clicks on the Nested Iframe")
    public void user_clicks_on_the_nested_iframe() {
        Click(nestedFrames.nestedFramesIcon);


   }
    @Then("User should be able to highlight the child iframe")
    public void user_should_be_able_to_highlight_the_child_iframe() throws InterruptedException {
       // driver.switchTo().frame("//iframe[@srcdoc='<p>Child Iframe</p>']");

    driver.switchTo().frame(nestedFrames.parentIframe);

     driver.switchTo().frame(nestedFrames.childIframe);
        Actions action = new Actions(driver);
        action.doubleClick().perform();
        driver.switchTo().defaultContent();



    }


}
