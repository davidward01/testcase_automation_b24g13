package test_cases.vytrack_cases.testplan_b24g13_sprint1;

import org.openqa.selenium.*;
import test_cases.utils.WebDriverFactory;

public class BGR13_34 {

        public static void main(String[] args) throws InterruptedException {
            String appUrl = "https://qa2.vytrack.com/";
            WebDriver driver = WebDriverFactory.getDriver("chrome");

            driver.manage().window().maximize();
            driver.get(appUrl);

            WebElement username = driver.findElement(By.cssSelector("input[name = '_username']"));
            username.sendKeys("user36");

            Thread.sleep(3000);

            WebElement password = driver.findElement(By.cssSelector("input[name = '_password']"));
            password.sendKeys("UserUser123");

            Thread.sleep(3000);


            WebElement login = driver.findElement(By.name("_submit"));
            login.click();


            Thread.sleep(3000);

            WebElement fleetOption = driver.findElement(By.cssSelector("span[class = 'title title-level-1']"));
            fleetOption.click();
            System.out.println("Done Mouse hover on 'Fleet' from Menu");

            Thread.sleep(3000);


            WebElement vehicleOption = driver.findElement(By.xpath("//span[@class='title title-level-2']"));
            System.out.println("Done Mouse hover on 'Vehicle' from Menu");
            vehicleOption.click();

            Thread.sleep(3000);

            //*[@id="grid-custom-entity-grid-1280464595"]/div[2]/div[1]/div/div[2]/div[2]/div/div/a
            WebElement gridBtn = driver.findElement(By.linkText("Export Grid"));


            Dimension gridBtnRect = gridBtn.getSize();
            System.out.println(gridBtnRect);

            System.out.println("Height location:" + gridBtn.getRect().height +   "  || " + " Width location: " +gridBtn.getRect().width);
            //System.out.println("Width location: " +gridBtn.getRect().width);

            Point location = gridBtn.getLocation();
            System.out.println("X location: " + location.getX() + "      || " + " Y location: " +location.getY());


        }
    }

