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
    private final String userName = "standard_user";
    private final String password = "secret_sauce";
    CheckoutOverview checkoutOverview;
    private final String expectedCheckoutPageURL = "https://www.saucedemo.com/checkout-step-one.html";

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
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.successfulLogin();
        productsPage = new ProductsPage(driver);
        productsPage.addTwoItemToTheCart();
        productsPage.clickOnCartIcon();
        cartPage = new CartPage(driver);
        checkoutPage = cartPage.clickCheckoutButton();
    }
    @When("the user enters first name {string}")
    public void the_user_enters_first_name(String firstName) {
            checkoutPage.setFirstName(firstName);
    }
    @And("the user enters last name {string}")
    public void userEntersPostalCode(String lastName) {
        checkoutPage.setFirstName(lastName);
    }

    @And("the user enters postal code {string}")
    public void the_user_enters_postal_code(String postalCode) {
        checkoutPage.setPostalCode(Integer.parseInt(postalCode));
    }
    @And("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        checkoutOverview = new CheckoutOverview(driver);
        checkoutOverview = checkoutPage.clickContinueButton();

    }

    @Then("the user is redirected to checkout overview page")
    public void the_user_is_redirected_to_checkout_overview_page() {
        Assert.assertEquals(expectedCheckoutPageURL, checkoutOverview.getURL());
    }

}
