package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Widgets extends CommonMethods {

    @FindBy(xpath = "(//div[@class='card-body'])[4]")
    public WebElement WidgetsIcon;

    @FindBy(xpath = "//span[text()='Date Picker']")
    public WebElement datePicker;

    @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[1]")
    public WebElement selectDate;

    @FindBy(id = "dateAndTimePickerInput")
    public WebElement DateAndTime;





    public Widgets(){
        PageFactory.initElements(driver,this);
    }

}
