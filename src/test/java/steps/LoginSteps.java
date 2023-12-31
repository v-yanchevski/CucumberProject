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
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps extends BaseSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    private final String expectedURL = "https://www.saucedemo.com/inventory.html";

    @Before
    public void openBrowser() {
        DriverManager.setUpDriver();
    }

    @Given("a user navigates to login page")
    public void a_user_navigates_to_login_page() {
        BaseSteps.navigateToLoginURL();
    }

    @When("a user enters valid credentials")
    public void a_user_enters_valid_credentials() {

        loginPage = new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();

    }

    @And("a user clicks on login button")
    public ProductsPage a_user_clicks_on_login_button() {
        productsPage = loginPage.clickLoginButton();
        return new ProductsPage(driver);

    }


    @Then("a user is navigated to the product page")
    public void a_user_is_navigated_to_the_product_page() {
        String actualURL = productsPage.getURL();
        Assert.assertEquals(expectedURL, actualURL);
    }

    @After
    public void closeBrowser() {
        DriverManager.tearDownDriver();
    }
}
