package steps;

import bases.BaseSteps;
import driverManager.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;

public class OrderCompleteSteps extends BaseSteps {

        private LoginPage loginPage;
        private ProductsPage productsPage;
        private CartPage cartPage;
        private CheckoutPage checkoutPage;
        private CheckoutOverview checkoutOverview;
        private CheckoutComplete checkoutComplete;
        private final String userName = "standard_user";
        private final String password = "secret_sauce";

        private final String expectedHeadline = "Thank you for your order!";

        @Before
        public void openBrowser() {
            DriverManager.setUpDriver();
        }

        @Given("a user is on checkout overview page")
        public void a_user_is_on_checkout_overview_page() {
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();
            loginPage = new LoginPage(driver);
            loginPage.successfulLogin(userName, password);
            productsPage = new ProductsPage(driver);
            productsPage.clickAddToCartButtons();
            productsPage.clickOnCartIcon();
            cartPage = new CartPage(driver);
            checkoutPage = cartPage.clickCheckoutButton();
            checkoutPage.setFirstName("John");
            checkoutPage.setLastName("Doe");
            checkoutPage.setPostalCode(12345);
            checkoutOverview = new CheckoutOverview(driver);
            checkoutOverview = checkoutPage.clickContinueButton();
        }

        @When("a user clicks on Finish button")
        public void a_user_clicks_on_finish_button() {
            checkoutComplete = new CheckoutComplete(driver);
            checkoutComplete = checkoutOverview.clickFinishButton();


        }

        @Then("a user sees an order confirmation headline")
        public void a_user_sees_an_order_confirmation_headline() {
            Assert.assertEquals(expectedHeadline,checkoutComplete.getHeadline());
        }
    }
