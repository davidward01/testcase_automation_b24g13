package test_cases.vytrack_cases;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test_cases.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class VT0006 {


    WebDriver driver;
    String url = "https://qa2.vytrack.com/user/login";

    @BeforeClass
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test                       //this is because we used Thread.sleep method (throws InterruptedException)
    public void refreshButton() throws InterruptedException {
        String id = "user37";
        String pw = "UserUser123";

        WebElement username = driver.findElement(By.name("_username"));
        username.sendKeys(id);

        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys(pw, Keys.ENTER);
        Thread.sleep(2000);

        // Locating the Fleet module (Parent element)
        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1']"));

        //Instantiating Actions class
        Actions action = new Actions(driver);

        // Hovering on Fleet module
        action.moveToElement(fleet);

        // Locating the element from Sub Menu
        WebElement vehicles = driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']"));

        // To mouseover on sub menu
        action.moveToElement(vehicles);

        ////build()- used to compile all the actions into a single step
        action.click().build().perform();

//Title Verification
        Thread.sleep(2000);
        String expectedTitle= "Car - Entities - System - Car - Entities - System";
        Assert.assertEquals(driver.getTitle(),expectedTitle,"Verification failed");

        //we used xpath 'following sibling' to identify Reset button
        //(identified Refresh button as following sibling of Reset button/ check the xpath)
        WebElement followingResetButton = driver.findElement(By.xpath("//a[@title='Refresh']//following-sibling::a"));

        //checking if following sibling of Refresh button.getText equals "Reset"
        Assert.assertEquals(followingResetButton.getText(),"Reset", "Something is wrong");
        System.out.println("Test Passed succesfully");

        //so following sibling of Reset button is Refresh. Parent is same (<div class="actions-panel pull-right form-horizontal" data-grid-actions-panel="">)
        // it means that Reset button comes before Refresh button.

    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
