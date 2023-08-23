package bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSteps {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Drivers\\chrome-win64\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void tearDownDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
