package test_cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarOutputStream;


public class TC0001 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "https://login2.nextbasecrm.com";
        driver.get(url);

        String loginPane = "USER_LOGIN";
        String actualUsername = "helpdesk25@cybertekschool.com";

        WebElement loginElement = driver.findElement(By.name(loginPane));
//        loginElement.click();
        loginElement.sendKeys(actualUsername);
        System.out.println("entered username");


        String passwordPane = "USER_PASSWORD";
        String actualPassword = "UserUser";
        WebElement passwordElement = driver.findElement(By.name(passwordPane));
//        passwordElement.click();
        passwordElement.sendKeys(actualPassword);
        System.out.println("entered password");

        String loginButton = "login-btn";
        driver.findElement(By.className(loginButton)).click();
        System.out.println("clicked login button");

        String expectedURL = "https://login2.nextbasecrm.com/stream/?login=yes";
        String actualURL = driver.getCurrentUrl();
        System.out.println("got current URL");

        if (expectedURL.equals(actualURL)){
            System.out.println("PASS - we are on the home page");
        } else {
            System.out.println("Fail - home page link does not match expected link");
        }
    }
}