package Steps;

import Pages.Widgets;
import Utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WidgetsDatePicker extends CommonMethods {
     // Widgets w= new Widgets();

    @When("user browse to the website")
    public void userBrowseToTheWebsite() {

     //openBrowserAndNavigateToURL();
    }

    @When("user clicks on Widget Icon")
    public void user_clicks_on_widget_icon() {
       Click(Widgets.widgets.widgetsIcon);
       isClickable(widgets.widgetsIcon);

         }
    @When("use clicks on Date Picker Icon")
    public void use_clicks_on_date_picker_icon() {
        Click(widgets.datePicker);
        isClickable(widgets.datePicker);

    }
    @Then("user should be able to pick any date as preferred")
    public void user_should_be_able_to_pick_any_date_as_preferred() throws InterruptedException {
        Click(widgets.selectDate);

        Select select = new Select(widgets.SelectMonths);
        select.selectByVisibleText("December");

        Select selct = new Select(widgets.SelectYear);
        selct.selectByVisibleText("2023");

        selectDayByVisible_Lists("5",widgets.SelectWeeks,widgets.dayLocator );

    }


}
