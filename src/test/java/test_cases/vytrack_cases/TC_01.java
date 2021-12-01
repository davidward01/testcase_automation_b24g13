package test_cases.vytrack_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test_cases.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TC_01 {
    String url = "https://qa2.vytrack.com/user/login";
    WebDriver driver;

    @BeforeClass
    public void startup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

//    @AfterClass
//    public void tearDown(){
//        driver.close();
//    }

    @Test
    public void checkTitle(){
        String expectedTitle = "Login";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void getVehicleInfo() throws InterruptedException {
        // enter username
        WebElement username = driver.findElement(By.name("_username"));
        username.sendKeys("user36");

        // enter pw
        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");

        // click Log In
        WebElement login = driver.findElement(By.id("_submit"));
        login.click();

        // hover on Fleet tab and click Vehicles button
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


}
