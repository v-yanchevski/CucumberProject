package steps;

import bases.BaseSteps;
import driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartSteps extends BaseSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private final String userName = "standard_user";
    private final String password = "secret_sauce";
    private final String expectedCartPageURL = "https://www.saucedemo.com/checkout-step-one.html";

    @Before
    public void openBrowser() {
        DriverManager.setUpDriver();
    }
    @After
    public void closeBrowser() {
        DriverManager.tearDownDriver();
    }

    @Given("user is on cart page")
    public void user_is_on_cart_page() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.successfulLogin();

    }

    @And("there are two products in the cart")
    public void there_are_two_products_in_the_cart() {
        productsPage = new ProductsPage(driver);
        productsPage.addTwoItemToTheCart();
        productsPage.clickOnCartIcon();
    }

    @When("a user clicks Remove on the first product")
    public void a_user_clicks_remove_on_the_first_product() {
        cartPage = new CartPage(driver);
        cartPage.removeFirstProductFromCart();
    }

    @Then("the product is removed from the cart")
    public void the_product_is_removed_from_the_cart() {
        Assert.assertTrue(cartPage.isProductRemovedFromTheCart());
    }

    @When("a user clicks on Checkout button")
    public void a_user_clicks_on_checkout_button() {
        cartPage = new CartPage(driver);
        checkoutPage = cartPage.clickCheckoutButton();
    }
    @Then("the user is navigated to information checkout page")
    public void the_user_is_navigated_to_information_checkout_page() {
        Assert.assertEquals(expectedCartPageURL, checkoutPage.getURL());

    }

}
