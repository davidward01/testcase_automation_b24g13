package test_cases.vytrack_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test_cases.utils.WebDriverFactory;

import java.util.List;

/*
truck drivers can add event
and it should be displayed under
Activity tab and General information page

1- Go to general info page of a car
2- Click on add event button
3- Fill out event details
4- Click save button
5- The event should be displayed in activities tab
 and general info page
 */
public class VT0003 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        String url = "https://qa2.vytrack.com/user/login";

//         login for Truck Driver "user36"
        driver.get(url);
        driver.findElement(By.name("_username")).sendKeys("user36");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.name("_submit")).click();
        Thread.sleep(5000);

//////////////////////////////////////////////////////////////////////////////////////////////////////

        //1- Go to general info page of a car
        String carsURL = "https://qa2.vytrack.com/entity/Extend_Entity_Carreservation";
        driver.get(carsURL);
        Thread.sleep(5000);

        List<WebElement> carsInFleet = driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']"));
        carsInFleet.get(0).click();
        Thread.sleep(5000);

//         2- Click on add event button
        WebElement addEvent = driver.findElement(By.xpath("//a[@class='btn icons-holder-text no-hash']"));
        addEvent.click();
        Thread.sleep(5000);

//        // 3-Fill out event details
        WebElement title = driver.findElement(By.xpath("//input[@data-name='field__title']"));
        title.click();
        String titleName = "test1";
        title.sendKeys(titleName);
        Thread.sleep(5000);

        WebElement displayName = driver.findElement(By.xpath("//input[@data-name='field__organizer-display-name']"));
        displayName.sendKeys("Albert");
        Thread.sleep(3000);

        //        4- Click save button
        WebElement saveButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        saveButton.click();

//        5- The event should be displayed in activities tab and general info page
        WebElement actualTitle = driver.findElement(By.xpath("//div[@class='message-item message']"));
        System.out.println(actualTitle.getText());

        if (actualTitle.getText().equals(titleName)){
            System.out.println("event is being displayed under General info tab");
        } else {
            System.out.println("something is wrong");
        }






    }
}
