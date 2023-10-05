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
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsSteps extends BaseSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private final String expectedCartPageURL = "https://www.saucedemo.com/cart.html";

    @Before
    public void openBrowser() {
        DriverManager.setUpDriver();
    }

    @Given("a user is on inventory page")
    public void a_user_is_on_inventory_page() {
        BaseSteps.navigateToLoginURL();
        loginPage = new LoginPage(driver);
        loginPage.successfulLogin();
    }


    @Then("a user sees all products")
    public void a_user_sees_all_products() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.areNamesVisible());
        Assert.assertTrue(productsPage.arePricesVisible());
    }


    @When("a user clicks on Add to cart button for products with indexes 0 and 2")
    public void a_user_clicks_on_add_to_cart_button() {

        productsPage = new ProductsPage(driver);
        productsPage.addTwoItemToTheCart();
    }

    @Then("the products are added to the cart")
    public void the_product_is_added_to_the_cart() {
        Assert.assertTrue(productsPage.areProductsAddedToTheCart());
    }


    @And("a user has added products to the cart")
    public void a_user_has_added_products_to_the_cart() {
        productsPage = new ProductsPage(driver);
        productsPage.addTwoItemToTheCart();
    }

    @When("a user clicks on Remove button")
    public void a_user_clicks_on_remove_button() {
        productsPage.clickRemoveFromCartButtons();

    }

    @Then("the products are removed from the cart")
    public void the_product_is_removed_from_the_cart() {
        Assert.assertTrue(productsPage.areProductsRemovedFromTheCart());

    }

    @When("a user click on cart icon")
    public void a_user_click_on_cart_icon() {
        cartPage = productsPage.clickOnCartIcon();
    }

    @Then("the user is navigated to the Cart page")
    public void the_user_is_navigated_to_the_cart_page() {
        Assert.assertEquals(expectedCartPageURL, cartPage.getURL());
    }


    @After
    public void closeBrowser() {
        DriverManager.tearDownDriver();
    }
}
