package test_cases.vytrack_cases.testplan_b24g13_sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test_cases.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @Author Mubarak
 */
public class BGR13_35 {

    WebDriver driver;
    String userName = "User36";
    String password = "UserUser123";


    @BeforeClass
    public void setUp(){
        String url = "https://qa2.vytrack.com/user/login";
        String expectedTitle = "Login";
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        assertEquals(driver.getTitle(), expectedTitle);
    }


    @Test(priority = 1)
    public void validateGridSettingsButton() throws InterruptedException {

        WebElement usernameBox = driver.findElement(By.name("_username"));
        WebElement passwordBox = driver.findElement(By.name("_password"));
        WebElement logInButton = driver.findElement(By.id("_submit"));

        usernameBox.sendKeys(userName);
        passwordBox.sendKeys(password);
        logInButton.click();

        Thread.sleep(5000);


        WebElement fleetDropdown = driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fleetDropdown).perform();

        Thread.sleep(3000);



        WebElement vehicleOption = driver.findElement(By.xpath("//span[text()='Vehicles']"));
        vehicleOption.click();


        Thread.sleep(3000);

        WebElement gridSettingsButton = driver.findElement(By.xpath("//div[@class='column-manager dropdown']"));
        assertTrue(gridSettingsButton.isDisplayed());

    }



    @AfterClass
    public void tearDown(){
        driver.close();
    }

}

