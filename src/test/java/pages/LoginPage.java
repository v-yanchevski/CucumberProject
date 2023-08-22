package pages;

import bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String userName) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.click();
        usernameInput.sendKeys(userName);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public ProductPage clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new ProductPage(driver);
    }
}
