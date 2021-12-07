package test_cases.vytrack_cases.testplan_b24g13_sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test_cases.utils.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

//   David
//   Export Grid Automation


//   Given we are on the Vehicles page
//   When we click Export Grid dropdown
//   Then we should see the dropdown options



public class BGR13_16 {

    WebDriver driver;
    String url = "https://qa2.vytrack.com/user/login";

    @BeforeClass
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void exportGrid() throws InterruptedException {
        String username = "User36";
        String password = "UserUser123";
        String expectedTitle = "Dashboard";

        WebElement usernameBox = driver.findElement(By.name("_username"));
        usernameBox.sendKeys(username);

        WebElement passwordBox = driver.findElement(By.name("_password"));
        passwordBox.sendKeys(password);

        WebElement logInButton = driver.findElement(By.id("_submit"));
        logInButton.click();

        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        WebElement fleetTab = driver.findElement(By.xpath("//span[contains(text(),'Fleet')]"));
        WebElement vehiclesButton = driver.findElement(By.xpath("//span[contains(text(),'Vehicles')]"));
        actions.moveToElement(fleetTab).perform();
        actions.moveToElement(vehiclesButton).perform();
        vehiclesButton.click();

        Thread.sleep(3000);

        WebElement export = driver.findElement(By.xpath("//div[@class='pull-left grid-toolbar-mass-actions']"));
//        WebElement export = driver.findElement(By.xpath("//a[@href='#']/i[@class='fa-upload']"));

        Assert.assertTrue(export.isEnabled() && export.isDisplayed(), "Fail: Export Dropdown is not visible");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }





}
