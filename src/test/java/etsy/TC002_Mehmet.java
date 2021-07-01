package etsy;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002_Mehmet {

    WebDriver driver = BrowserFactory.getDriver("chrome");

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void testcase002(){

    }

    @AfterClass
    public void quitDriver(){
        driver.quit();
    }
}