package Runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features = "src/test/java/Feature",
        glue = "StepDefs")
public class TestRunner extends AbstractTestNGCucumberTests{
    private static WebDriver driver;

    @BeforeSuite
    public void setupSuite() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public static WebDriver getDriver(){
        return driver;
    }

}
