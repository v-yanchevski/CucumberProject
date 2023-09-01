package pages;

import bases.BasePage;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
}
