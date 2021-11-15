package test_cases.vytrack_cases.truckdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import test_cases.utils.VytrackLogin;
import test_cases.utils.WebDriverFactory;

import javax.swing.plaf.ActionMapUIResource;
import java.util.Collections;
import java.util.List;

public class VT0002 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);

        // login for Truck Driver "user36"
        driver.findElement(By.name("_username")).sendKeys("user36");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.name("_submit")).click();

        Thread.sleep(3000);
        String carsURL = "https://qa2.vytrack.com/entity/Extend_Entity_Carreservation";
        driver.navigate().to(carsURL);

        Thread.sleep(3000);
        List<WebElement> carsInFleet = driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']"));

        Collections.shuffle(carsInFleet);
        carsInFleet.get(0).click();

        String expectedTitle = driver.getTitle();

        if (expectedTitle.contains("Car")){
            System.out.println("PASS - Vehicle information is visible");
        } else {
            System.out.println("FAIL - Vehicle information is not visible");
        }
    }
}
