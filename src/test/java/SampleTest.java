import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;

public class SampleTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CheckoutPge checkoutPge;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        checkoutPge = new CheckoutPge(driver);
    }
    @Test(priority = 1)
    public void loginTest(){
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.isOnHomePage(), "login failed, couldn't get to homepage.");
    }
    @Test(priority = 2)
    public void validateHomepageInventory(){
        Assert.assertEquals(homePage.getInventoryCount(), 6, "Inventory count does not match.");
    }
    @Test(priority = 3)
    public void verifyCheckoutPageItems(){
//        List<String> expectedItem = new ArrayList<>();
//        expectedItem.add("Sauce Labs Backpack");
//        expectedItem.add("Sauce Labs Bolt T-Shirt");
//
//        checkoutPge.userInfo("Ram", "Ghimire", "12345");
//        List<String> itemnames = checkoutPge.getItemNames();
//        Assert.assertEquals(itemnames, expectedItem, "item not in checkout page");
//
        checkoutPge.pickItems();
        checkoutPge.checkout();
        checkoutPge.userInfo("myFirstName", "myLastName", "12345");
        List<String> expected = checkoutPge.getExpectedItem("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt");
        List<String>actualItems= checkoutPge.getItemNames();
        Assert.assertEquals(actualItems, expected, "item not in checkout page");

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}