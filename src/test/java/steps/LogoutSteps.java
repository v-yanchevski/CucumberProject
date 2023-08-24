package steps;

import bases.BaseSteps;
import driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.SideMenu;

public class LogoutSteps extends BaseSteps {

    private LoginPage loginPage;
    private SideMenu sideMenu;
    private String expectedURL = "https://www.saucedemo.com/";

    @Before
    public void openBrowser() {
        DriverManager.setUpDriver();
    }

    @Given("a user is on product page")
    public void a_user_is_on_product_page() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.successfulLogin("standard_user", "secret_sauce");

    }

    @When("a user clicks on side menu")
    public void a_user_clicks_on_side_menu() {
        sideMenu = new SideMenu(driver);
        sideMenu.clickSideMenu();

    }

    @When("a user click on logout button")
    public void a_user_click_on_logout_button() {
        sideMenu.clickLogoutButton();

    }

    @Then("a user is navigated to login page")
    public void a_user_is_navigated_to_login_page() {
        String actualURL = loginPage.getURL();
        Assert.assertEquals(expectedURL, actualURL);
    }

    @After
    public void closeBrowser() {
        DriverManager.tearDownDriver();
    }
}
