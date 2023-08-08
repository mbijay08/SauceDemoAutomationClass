package Pages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="user-name")
    private WebElement userInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@name='login-button']")
    private WebElement loginButton;
    // takes username and password from user to login
    public void login(String username, String password){
        //Wait<WebDriver> wat = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        userInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
