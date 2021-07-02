package etsy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TC005_uguryilmazer {
    WebDriver driver ;
    @BeforeMethod
    public void setup(){
    driver= BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
    Thread.sleep(2000);
    driver.close();
    }
    @Test
    public void testcase001(){
    driver.get("https://www.etsy.com/");


    }
}
