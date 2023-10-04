package pages;

import bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CheckoutOverview extends BasePage {

    @FindBy (id = "finish")
    WebElement finishButton;

    @FindBy (id = "cancel")
    WebElement cancelButton;

    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }

    public CheckoutComplete clickFinishButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        finishButton.click();
        return new CheckoutComplete(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }
}
