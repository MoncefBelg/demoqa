package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Widgets extends CommonMethods {

    @FindBy(xpath = "(//div[@class='card-body'])[4]")
    public WebElement widgetsIcon;

    @FindBy(xpath = "//span[text()='Date Picker']")
    public WebElement datePicker;

    @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[1]")
    public WebElement selectDate;

    @FindBy(id = "dateAndTimePickerInput")
    public WebElement DateAndTime;

    @FindBy(xpath = "//select[@class=\"react-datepicker__month-select\"]")
    public WebElement SelectMonths;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    public WebElement SelectYear;

    @FindBy(xpath = "//div[@class=\"react-datepicker__week\"]")
    public List<WebElement> SelectWeeks;

    public By dayLocator = By.xpath(".//div[contains(@class, 'react-datepicker__day')]");






    public Widgets(){
        PageFactory.initElements(driver,this);
    }

}
