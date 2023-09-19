package pages;

import bases.BasePage;
import org.openqa.selenium.WebDriver;

public class CheckoutOverview extends BasePage {
    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }
    public String getURL() {
        return driver.getCurrentUrl();
    }
}
