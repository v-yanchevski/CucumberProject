package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import java.time.Duration;

public class LoginPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

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
