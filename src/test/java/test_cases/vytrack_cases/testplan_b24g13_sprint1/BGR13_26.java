package test_cases.vytrack_cases.testplan_b24g13_sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test_cases.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class BGR13_26 {

        WebDriver driver;
        String url = "https://qa2.vytrack.com/user/login";

        @BeforeClass
        public void setUp() {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.get(url);
        }

        @Test
        public void logIn() throws InterruptedException {
            String username = "User36";
            String password = "UserUser123";
            String login;

            //Login with username and password
            driver.findElement(By.name("_username")).sendKeys(username);
            driver.findElement(By.name("_password")).sendKeys(password);
            driver.findElement(By.id("_submit")).click();

            //verify on correct page by checking the title
            System.out.println("Title of the page = " + driver.getTitle());
            Assert.assertEquals(driver.getTitle(), "Dashboard");

            //click Fleet and Vehicles button
            driver.findElement(By.linkText("Fleet")).click();
            driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span")).click();

            //click the refresh button and print the test result
            WebElement RefreshBtn = driver.findElement(By.xpath("//i[@class='fa-repeat']"));
            RefreshBtn.click();
            System.out.println("Test is passed successfully " + RefreshBtn.getText());

        }

        @AfterClass
        public void tearDown(){
            System.out.println("Test closing");
        }
    }

