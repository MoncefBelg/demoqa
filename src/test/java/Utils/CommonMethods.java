package Utils;

import Steps.PageInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonMethods extends PageInitializer {

      public static WebDriver driver;
    public static void openBrowserAndNavigateToURL(){
        ConfigReader.readProperty(Constants.CONFIG_READER_PATH);

    switch (ConfigReader.getPropertyValue("browser")){

        case "chrome" :
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=C:/temp/chrome-profile-" + System.currentTimeMillis());
             driver = new ChromeDriver(options);
             break;

        case "firefox" :
            FirefoxOptions options1=new FirefoxOptions();
            options1.addArguments("user-data-dir=C:/temp/firefox-profile-" + System.currentTimeMillis());
            driver = new FirefoxDriver(options1);
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


}
