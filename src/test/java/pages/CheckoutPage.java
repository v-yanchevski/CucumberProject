package pages;

import bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class, 'title')]")
    WebElement title;
    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(id = "cancel")
    WebElement backButton;
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void setFirstName() {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.click();
        firstNameInput.sendKeys(orderFirstName);
    }

    public void setLastName() {
        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        lastNameInput.click();
        lastNameInput.sendKeys(orderLastName);
    }

    public void setPostalCode() {
        wait.until(ExpectedConditions.visibilityOf(postalCodeInput));
        postalCodeInput.click();
        postalCodeInput.sendKeys(String.valueOf(orderPostalCode));
    }

    public CheckoutOverview clickContinueButton() {
        continueButton.click();
        return new CheckoutOverview(driver);
    }
}
