package Steps;

import Pages.Widgets;
import Utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WidgetsDatePicker extends CommonMethods {
    Widgets widgets;

    @When("user browse to the website")
    public void userBrowseToTheWebsite() {

     openBrowserAndNavigateToURL();
    }

    @When("user clicks on Widget Icon")
    public void user_clicks_on_widget_icon() {

     performClick(Widgets.);    }
    @When("use clicks on Date Picker Icon")
    public void use_clicks_on_date_picker_icon() {


    }
    @Then("user should be able to pick any date as preferred")
    public void user_should_be_able_to_pick_any_date_as_preferred() {



    }


}
