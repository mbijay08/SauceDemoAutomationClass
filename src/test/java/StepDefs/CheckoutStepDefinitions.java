package StepDefs;
import Pages.CheckoutPge;
import Pages.LoginPage;
import Runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckoutStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private CheckoutPge checkoutPge;

    public CheckoutStepDefinitions() {
        this.driver = TestRunner.getDriver();
        this.checkoutPge = new CheckoutPge(driver);
    }
    @Given("user is on homepage")
    public void user_is_on_homepage() {

    }
    @When("user picks required items")
    public void user_picks_required_items() {
        checkoutPge.pickItems();
    }
    @When("user clicks checkout button")
    public void user_clicks_checkout_button() {
        checkoutPge.checkout();
    }
    @When("user inputs first name {string} and last name {string} and zip {string}")
    public void user_inputs_first_name_and_last_name_and_zip(String string, String string2, String string3) {
        checkoutPge.userInfo(string, string2, string3);
    }
    @Then("user is able to see all the added items in cart")
    public void user_is_able_to_see_all_the_added_items_in_cart() {
        List<String> expectedItem = new ArrayList<>();
        expectedItem.add("Sauce Labs Backpack");
        expectedItem.add("Sauce Labs Bolt T-Shirt");
        List<String> itemnames = checkoutPge.getItemNames();
        Assert.assertEquals(itemnames, expectedItem, "item not in checkout page");
    }
}
