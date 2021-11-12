package test_cases.vytrack_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import test_cases.utils.VytrackLogin;
import test_cases.utils.WebDriverFactory;

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
        driver.navigate().to("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation");

        Thread.sleep(3000);
        driver.findElement(By.linkText("java.util.Random@7c22d4f")).click();

//        Actions act = new Actions(driver);
//        act.moveToElement(driver.findElement(By.linkText(" Fleet"))).perform();
//
//        driver.findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']")).click();
//
       List<WebElement> carsInFleet = driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']"));

//        for (WebElement each : carsInFleet) {
//            System.out.println(each.getText());
//        }

        System.out.println(carsInFleet);

//        Collections.shuffle(carsInFleet);
//        carsInFleet.get(0).click();


    }
}
