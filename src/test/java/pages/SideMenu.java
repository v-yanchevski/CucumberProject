package pages;

import bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SideMenu extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    WebElement sideMenu;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;

    public SideMenu(WebDriver driver) {

        super(driver);
    }

    public void clickSideMenu(){
        wait.until(ExpectedConditions.visibilityOf(sideMenu));
        sideMenu.click();
    }

    public LoginPage clickLogoutButton(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
        return new LoginPage(driver);
    }
}
