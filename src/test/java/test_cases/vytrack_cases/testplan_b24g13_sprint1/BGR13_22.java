package test_cases.vytrack_cases.testplan_b24g13_sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test_cases.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class BGR13_22 {

    String url = "https://qa2.vytrack.com/user/login";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        driver.findElement(By.id("prependedInput")).sendKeys("user36");
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("button[class = 'btn btn-uppercase btn-primary pull-right']")).click();
    }

    @Test
    public void TestAutomation(){

        driver.findElement(By.xpath("//span[@class = 'title title-level-1'][1]")).click();
        driver.findElement(By.xpath("//*[.='Vehicles']")).click();

        // find refresh button using the class name
        WebElement refresh =  driver.findElement(By.className("fa-repeat"));

        // verify refresh button isDisplayed
        Assert.assertTrue(refresh.isDisplayed());

        // click refresh after it's verified
        refresh.click();
        System.out.println("Passed");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
