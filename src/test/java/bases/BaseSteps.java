package bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSteps {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static String userName = "standard_user";
    public static String password = "secret_sauce";
    public static String loginURL = "https://www.saucedemo.com/";

    public BaseSteps() {
        this.driver = driverManager.DriverManager.getDriver();
        this.wait = driverManager.DriverManager.getWait();
    }

    public static void navigateToLoginURL() {
        driver.get(loginURL);
        driver.manage().window().maximize();

    }
}
