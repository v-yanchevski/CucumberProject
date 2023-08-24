package bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSteps {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseSteps() {
        this.driver = driverManager.DriverManager.getDriver();
        this.wait = driverManager.DriverManager.getWait();
    }
}
