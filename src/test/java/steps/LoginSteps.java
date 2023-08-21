package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.ProductPage;

import java.time.Duration;

public class LoginSteps {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected ProductPage productPage;

    @Given("a user opens a browser")
    public void a_user_opens_a_browser() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Drivers\\chrome-win64\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @And("a user navigates to login page")
    public void a_user_navigates_to_login_page() {
        driver.get("https://www.saucedemo.com/");

    }

    @When("a user enters valid credentials")
    public void a_user_enters_valid_credentials() {

        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

    }

    @And("a user clicks on login button")
    public ProductPage a_user_clicks_on_login_button() {
        productPage = loginPage.clickLoginBtn();
        return new ProductPage(driver);

    }


    @Then("a user is navigated to the product page")
    public void a_user_is_navigated_to_the_product_page() {
        String actualTitle = productPage.getPageTitle();
        Assert.assertEquals("Swag Labs", actualTitle);
        driver.quit();
    }

}
