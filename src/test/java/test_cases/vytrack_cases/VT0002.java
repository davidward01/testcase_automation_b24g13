package test_cases.vytrack_cases;

import org.openqa.selenium.WebDriver;
import test_cases.utils.VytrackLogin;
import test_cases.utils.WebDriverFactory;

public class VT0002 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        VytrackLogin.loginToVytrack();

    }
}
