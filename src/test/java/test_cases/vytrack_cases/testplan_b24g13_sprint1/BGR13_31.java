package test_cases.vytrack_cases.testplan_b24g13_sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test_cases.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;


    public class BGR13_31 {

        String appUrl = "https://qa2.vytrack.com";
        String UserName = "user40";
        String password = "UserUser123";
        WebDriver driver;


        @BeforeClass
        public void setUp(){
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get(appUrl);
        }

        @Test(priority = 1)

        public void Login() throws InterruptedException {
            //<input type="text" id="prependedInput" class="span2" name="_username" value="" required="required" placeholder="Username or Email" autofocus="">

            WebElement userNameBox = driver.findElement(By.id("prependedInput"));
            userNameBox.sendKeys(UserName);

            //<input type="password" id="prependedInput2" class="span2" name="_password" required="required" placeholder="Password" autocomplete="off">
            WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
            passwordBox.sendKeys(password);

            Thread.sleep(2000);


            //<button type="submit" class="btn btn-uppercase btn-primary pull-right" id="_submit" name="_submit">Log in</button>
            WebElement loginBtn = driver.findElement(By.id("_submit"));
            loginBtn.click();

        }

        @Test(priority = 2)
        public void openVehicleModule() throws InterruptedException {
            //<span class="title title-level-1"><i class="fa-asterisk menu-icon"></i>
            //    Fleet</span>
            WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
            fleet.click();

            Thread.sleep(2000);


            //<span class="title title-level-2">Vehicles</span>
            WebElement vehiclesBtn = driver.findElement(By.xpath("//span[@class='title title-level-2']"));
            vehiclesBtn.click();
            Thread.sleep(2000);

        }

        @Test(priority = 3)

        public void ResetButton(){

            //<i class="fa-chevron-right hide-text">
            //                Next
            //            </i>
            WebElement nextButton = driver.findElement(By.xpath("//i[@class='fa-chevron-right hide-text']"));
            nextButton.click();





            //<i class="fa-refresh"></i>
            WebElement resetButton = driver.findElement(By.linkText("Reset"));
            resetButton.click();


        }


    }


