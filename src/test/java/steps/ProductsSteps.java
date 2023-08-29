package steps;

import bases.BaseSteps;
import driverManager.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsSteps extends BaseSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private final String userName = "standard_user";
    private final String password = "secret_sauce";

    @Before
    public void openBrowser() {
        DriverManager.setUpDriver();
    }

    @Given("a user is on inventory page")
    public void a_user_is_on_inventory_page() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.successfulLogin(userName, password);

    }


    @Then("a user sees all products")
    public void a_user_sees_all_products() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.areNamesVisible());
        Assert.assertTrue(productsPage.arePricesVisible());
    }

}
