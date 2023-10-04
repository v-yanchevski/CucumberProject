package pages;

import bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutComplete extends BasePage {
    @FindBy(css = ".complete-header")
    WebElement headline;

    @FindBy(id = "back-to-products")
    WebElement backButton;

    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }

    public String getHeadline() {
        return headline.getText();
    }
}
