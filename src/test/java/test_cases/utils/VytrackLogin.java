package test_cases.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class VytrackLogin {
    public static void main(String[] args) {
    }

    public static void loginToVytrack(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);

        // login for Truck Driver "user36"
        driver.findElement(By.name("_username")).sendKeys("user36");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.name("_submit")).click();
    }
}
