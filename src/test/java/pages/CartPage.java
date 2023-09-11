package pages;

import bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[contains(@id,'remove')]")
    WebElement removeButtonForFirstProduct;
    @FindBy(id = "shopping_cart_container")
    WebElement shoppingCartIcon;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void removeFirstProductFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(removeButtonForFirstProduct)).click();
    }

    public boolean isProductRemovedFromTheCart() {
        wait.until(ExpectedConditions.visibilityOf(shoppingCartIcon));
        String badgeValueText = shoppingCartIcon.getText();
        int badgeValue = Integer.parseInt(badgeValueText);

        return badgeValue < 2;
    }

    public CheckoutPage clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }


    public String getURL() {
        return driver.getCurrentUrl();
    }
}
