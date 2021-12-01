package test_cases.vytrack_cases.testplan_b24g13_sprint1;

import test_cases.utils.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class BGR13_20 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        String url = "https://qa2.vytrack.com/user/login";
        String expectedTitle = "Login";
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test (priority = 1)
    public void logIn(){
        String username = "User36";
        String password = "UserUser123";
        String expectedTitle = "Dashboard";
        WebElement usernameBox = driver.findElement(By.name("_username"));
        usernameBox.sendKeys(username);
        WebElement passwordBox = driver.findElement(By.name("_password"));
        passwordBox.sendKeys(password);
        WebElement logInButton = driver.findElement(By.id("_submit"));
        logInButton.click();
        assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test (priority = 2)
    public void navigateToVehiclesPage() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement fleetTab = driver.findElement(By.xpath("//span[contains(text(),'Fleet')]"));
        WebElement vehiclesButton = driver.findElement(By.xpath("//span[contains(text(),'Vehicles')]"));
        actions.moveToElement(fleetTab).perform();
        actions.moveToElement(vehiclesButton).perform();
        vehiclesButton.click();

        Thread.sleep(5000);

        //verify correct page opens after clicking vehicles
        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        assertEquals(driver.getTitle(), expectedTitle);
    }

    // had to steal Mert's solution for finding the Refresh button element
    @Test (priority = 3)
    public void findPosition() throws IOException {

        WebElement followingResetButton = driver.findElement(By.xpath("//a[@title='Refresh']//following-sibling::a"));

        //checking if following sibling of Refresh button.getText equals "Reset"
        Assert.assertEquals(followingResetButton.getText(),"Reset", "Something is wrong");
        System.out.println("Test Passed successfully");
    }


    // cannot find this element, so I automated a screenshot
    @Test (priority = 4)
    public void takeScreenshot() throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\screenshots\\screenshot.png"));

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
