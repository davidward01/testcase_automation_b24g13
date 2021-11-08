package test_cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC0003 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "https://login2.nextbasecrm.com";
        driver.get(url);

        WebElement clickRemember = driver.findElement(By.id("USER_REMEMBER"));
        clickRemember.click();

        if (clickRemember.isSelected()){
            System.out.println("PASS - 'remember me on this computer' button is selected");
        } else  {
            System.out.println("FAIL - 'remember me on this computer' button is not selected");
        }


    }
}
