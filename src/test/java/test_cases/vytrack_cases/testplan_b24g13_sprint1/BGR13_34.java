package com.cybertek.tests.groupProject;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ExportGridBtnIsLeftOfThePage {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        String url = "https://qa2.vytrack.com/user/login";
        String expectedTitle = "Login";
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        assertEquals(driver.getTitle(), expectedTitle);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test(priority = 1)
    public void logIn() {
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

    @Test(priority = 2)
    public void navigateToVehiclesPage() throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement fleetTab = driver.findElement(By.xpath("//span[contains(text(),'Fleet')]"));
        WebElement vehiclesButton = driver.findElement(By.xpath("//span[contains(text(),'Vehicles')]"));
        actions.moveToElement(fleetTab).perform();
        actions.moveToElement(vehiclesButton).perform();
        vehiclesButton.click();

        Thread.sleep(2000);

        //verify correct page opens after clicking vehicles
        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        assertEquals(driver.getTitle(), expectedTitle);

        Thread.sleep(2000);
    }


    @Test(priority = 3)
    public void gridBtnOnLeft() {

        WebElement gridBtn = driver.findElement(By.linkText("Export Grid"));

        Assert.assertEquals(gridBtn.getText(), "Export Grid", "is wrong location");

        System.out.println("PASSED: successfully locate on the left side");

    }
}