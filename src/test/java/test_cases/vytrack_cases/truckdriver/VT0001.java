package test_cases.vytrack_cases.truckdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import test_cases.utils.VytrackLogin;
import test_cases.utils.WebDriverFactory;

import javax.swing.*;
import java.util.List;

public class VT0001 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);

        // login for Truck Driver "user36"
        driver.findElement(By.name("_username")).sendKeys("user36");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.name("_submit")).click();

        Thread.sleep(2000);

        WebElement targetDropdown = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));

        Actions act = new Actions(driver);
        act.moveToElement(targetDropdown).perform();

        WebElement vehiclesButton = driver.findElement(By.xpath("//span[text()='Vehicles']"));
        vehiclesButton.click();

        Thread.sleep(2000);

        List<WebElement> carsInFleet = driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']"));

        System.out.println(carsInFleet);

        if (!carsInFleet.isEmpty()){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }


    }
}
