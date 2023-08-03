import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPge extends BasePage {
    public CheckoutPge(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpack;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private  WebElement tshirt;
    @FindBy(id = "shopping_cart_container")
    private WebElement cart;
    @FindBy(id = "checkout")
    private WebElement checkoutBtn;
    @FindBy(id="first-name")
    private WebElement firstName;
    @FindBy(id="last-name")
    private WebElement lastName;
    @FindBy(id="postal-code")
    private WebElement zipCode;
    @FindBy(id = "continue")
    private WebElement continueBtn;

    public boolean isOnCheckoutPage(){
        return driver.getCurrentUrl().contains("checkout-step-one.html");
    }
    public void pickItems(){
        backpack.click();
        tshirt.click();
        cart.click();
    }
    public void checkout(){
        checkoutBtn.click();
    }
    public void userInfo(String firstname, String lastname, String zip){
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        zipCode.sendKeys(zip);
        continueBtn.click();
    }

    public List<String> getItemNames(){
        return itemNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> NewMethod(String string1, String string2) {
        pickItems();
        checkout();
        userInfo(string1, string2, "12346");
        return getItemNames();
    }


    }