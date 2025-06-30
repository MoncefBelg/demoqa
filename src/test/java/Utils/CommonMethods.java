package Utils;

import Steps.PageInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

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
}
