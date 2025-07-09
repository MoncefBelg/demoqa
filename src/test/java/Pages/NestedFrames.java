package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFrames extends CommonMethods {

    @FindBy(xpath = "//div[text()='Alerts, Frame & Windows']")
    public WebElement Alerts_Frame_Windows;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    public WebElement nestedFramesIcon;

    @FindBy(xpath = "//iframe[@id='frame1']")
    public WebElement parentIframe;

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    public WebElement childIframe;



    public NestedFrames(){
        PageFactory.initElements(driver,this);
    }


}
