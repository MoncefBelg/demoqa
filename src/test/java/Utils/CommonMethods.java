package Utils;

import Steps.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer {

      public static WebDriver driver;

    public static void openBrowserAndNavigateToURL() throws MalformedURLException {
        ConfigReader.readProperty(Constants.CONFIG_READER_PATH);

        String browser = ConfigReader.getPropertyValue("browser");
      //  String gridURL = ConfigReader.getPropertyValue("gridURL");


            switch(browser.toLowerCase()){

        case "chrome" :
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("user-data-dir=C:/temp/chrome-profile-" + System.currentTimeMillis());
            // driver = new ChromeDriver(options);
           // driver = new RemoteWebDriver(new URL(gridURL), chromeOptions);
            driver = new ChromeDriver();
             break;

        case "firefox" :
            FirefoxOptions firefoxOptions=new FirefoxOptions();
            firefoxOptions.addArguments("user-data-dir=C:/temp/firefox-profile-" + System.currentTimeMillis());
            //driver = new FirefoxDriver(firefoxOptions);
          //  driver = new RemoteWebDriver(new URL(gridURL), firefoxOptions);

            break;
    }

    driver.manage().window().maximize();
    driver.get(ConfigReader.getPropertyValue("Website"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        initializePageObjects();
    }

    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }
    public static void WaitForClickability(WebElement element){
      getWait().until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void Click(WebElement element){
        WaitForClickability(element);
        element.click();

    }

    public static boolean isClickable(WebElement element) {
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is not clickable within the timeout: " + element);
            return false;
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            return false;
        }
    }

        public static void closeBrowser() {
            try {
                if (driver != null) {
                    driver.quit();
                    driver = null;
                }
            } catch (Exception e) {
                e.printStackTrace(); // Actually logs the error
            }
    }

    public void selectDayByVisible_Lists(String dayToSelect, List<WebElement> weekElements, By dayXPath) {
        for (WebElement week : weekElements) {
            List<WebElement> days = week.findElements(dayXPath);

            for (WebElement day : days) {
                String text = day.getText().trim();
                if (text.equals(dayToSelect)) {
                    if (day.isDisplayed() && day.isEnabled()) {
                        day.click();
                        return;
                    }
                }
            }
        }

        System.out.println("Day " + dayToSelect + " not found or not interactable.");
    }

    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        //we write this line because cucumber accepts array of byte for screenshot
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File screenShot = ts.getScreenshotAs(OutputType.FILE);
        //in case if it doesn't find file name or path it will throw an exception

        try{
            FileUtils.copyFile(screenShot,
                    new File(Constants.SCREENSHOT_FILEPATH + fileName+" "
                            +getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern){
        //it returns the current date and time in java
        Date date = new Date();
        //this function sdf used to format the date as per the pattern we are passing
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        //this line is going to return the formatted date
        return sdf.format(date);
    }

}
