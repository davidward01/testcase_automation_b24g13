package test_cases.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextbaseLogin {
    public static void main(String[] args) {

    }

    public static void loginToNextbase(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "https://login2.nextbasecrm.com";
        driver.get(url);

        String loginPane = "USER_LOGIN";
        String actualUsername = "helpdesk25@cybertekschool.com";
        WebElement loginElement = driver.findElement(By.name(loginPane));

        loginElement.sendKeys(actualUsername);

        String passwordPane = "USER_PASSWORD";
        String actualPassword = "UserUser";
        WebElement passwordElement = driver.findElement(By.name(passwordPane));

        passwordElement.sendKeys(actualPassword);

        String loginButton = "login-btn";
        driver.findElement(By.className(loginButton)).click();

    }
}
