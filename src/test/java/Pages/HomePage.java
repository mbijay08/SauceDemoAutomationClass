package Pages;

import Pages.BasePage;
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

    public boolean isOnHomePage(){
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public int getInventoryCount(){
        return inventoryItems.size();
    }

}
