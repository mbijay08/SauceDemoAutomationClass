import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SampleTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CheckoutPge checkoutPge;

    @BeforeClass
    public void setUp(){
        try{
        driver = new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        checkoutPge = new CheckoutPge(driver);
         }catch (Exception e) {
            System.out.println("Failed to set up Web driver");
        }
    }
    @Test(priority = 1)
    public void loginTest(){
        loginPage.login("standard_user", "secret_sauce");
        // explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("/inventory.html"));

        Assert.assertTrue(homePage.isOnHomePage(), "login failed, couldn't get to homepage.");
    }
    @Test(priority = 2)
    public void validateHomepageInventory(){
        Assert.assertEquals(homePage.getInventoryCount(), 6, "Inventory count does not match.");
    }
    @Test(priority = 3)
    public void verifyCheckoutPageItems(){
        checkoutPge.pickItems();
        checkoutPge.checkout();
        checkoutPge.userInfo("myFirstName", "myLastName","12345");
        List<String> expected = checkoutPge.getExpectedItem("Sauce Labs Backpack","Sauce Labs Bolt T-Shirt");
        List<String>actualItems= checkoutPge.getItemNames();
        Assert.assertEquals(actualItems, expected, "item not in checkout page");
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}