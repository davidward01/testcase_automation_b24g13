package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


/**
 *  WebDriverFactory class:
 *      is used to create WebDriver(Selenium) object and return it.
 *      It will open the browser and maximize it
 *      method:
 *          getDriver(String browserType)
 *          - will check browser type and return object:
 *              if browserType is "chrome":
 *                  will set up chrome driver, return new ChromeDriver
 *
 */
public class WebDriverFactory {
    public static WebDriver getDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        } else if (browserType.equalsIgnoreCase("safari")){
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        } else {
            System.out.println("Invalid browser type = " + browserType);
            return null;    // null means No object
        }
    }
}


