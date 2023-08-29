package pages;

import bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> productsName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    List<WebElement> productsPrice;

    @FindBy(xpath = "//button[text()='Add to cart']")
    List<WebElement> addToCartButtons;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButtonIndex0;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addToCartButtonIndex2;

    @FindBy(css = "#shopping_cart_container")
    WebElement shoppingCartIcon;

    public ProductsPage(WebDriver driver) {
        super(driver);

    }
    public ProductsPage successfulLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        return loginPage.clickLoginButton();
    }
    public void clickAddToCartButtons() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonIndex0)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonIndex2)).click();
    }

    public boolean areNamesVisible() {
        for (WebElement element : productsName) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean arePricesVisible() {
        for (WebElement element : productsPrice) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areAddToCartVisible() {
        for (WebElement element : addToCartButtons) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isProductAddedToTheCart() {
        wait.until(ExpectedConditions.visibilityOf(shoppingCartIcon));
        String badgeValueText = shoppingCartIcon.getText();
        int badgeValue = Integer.parseInt(badgeValueText);

        return badgeValue > 0;

    }

    public CartPage clickOnCartIcon() {
        shoppingCartIcon.click();
        return new CartPage(driver);
    }
    public String getURL() {
        return driver.getCurrentUrl();
    }
}
