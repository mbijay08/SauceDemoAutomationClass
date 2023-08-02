import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    //to validate if we are on homepage or not by checking inventory
    public boolean isOnHomePage(){
        return driver.getCurrentUrl().contains("inventory.html");
    }
    // returns the count of inventory available
    public int getInventoryCount(){
        return inventoryItems.size();
    }

}
