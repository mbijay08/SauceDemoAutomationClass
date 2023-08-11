package StepDefs;

import Pages.HomePage;
import Pages.LoginPage;
import Runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.TestRunner.*;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    public LoginStepDefinitions() {
        this.driver = TestRunner.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        //driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        //loginPage = new LoginPage(driver);
    }
    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginBtn();
    }
    @Then("user should be on homepage")
    public void user_should_be_on_homepage() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isOnHomePage(), "Not on the homepage");
    }
    @Then("user should be able to see inventory count")
    public void user_should_be_able_to_see_inventory_count() {
        Assert.assertEquals(homePage.getInventoryCount(), 6, "Inventory does not match");
    }
}
