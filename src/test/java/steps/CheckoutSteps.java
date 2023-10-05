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
import pages.*;


public class CheckoutSteps extends BaseSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    CheckoutOverview checkoutOverview;
    private final String expectedCheckoutPageURL = "https://www.saucedemo.com/checkout-step-two.html";

    @Before
    public void openBrowser() {
        DriverManager.setUpDriver();
    }

    @After
    public void closeBrowser() {
        DriverManager.tearDownDriver();
    }

    @Given("the user is on the checkout step page")
    public void the_user_is_on_the_checkout_step_page() {
        BaseSteps.navigateToLoginURL();
        loginPage = new LoginPage(driver);
        loginPage.successfulLogin();
        productsPage = new ProductsPage(driver);
        productsPage.addTwoItemToTheCart();
        productsPage.clickOnCartIcon();
        cartPage = new CartPage(driver);
        checkoutPage = cartPage.clickCheckoutButton();
    }

    @When("the user enters first name")
    public void the_user_enters_first_name() {
        checkoutPage.setFirstName();
    }

    @And("the user enters last name")
    public void the_user_enters_last_name() {
        checkoutPage.setLastName();
    }

    @And("the user enters postal code")
    public void the_user_enters_postal_code() {
        checkoutPage.setPostalCode();
    }

    @And("the user clicks the Continue button")
    public void the_user_clicks_the_button() {
        checkoutOverview = new CheckoutOverview(driver);
        checkoutOverview = checkoutPage.clickContinueButton();

    }

    @Then("the user is redirected to checkout overview page")
    public void the_user_is_redirected_to_checkout_overview_page() {
        Assert.assertEquals(expectedCheckoutPageURL, checkoutOverview.getURL());
    }

}
