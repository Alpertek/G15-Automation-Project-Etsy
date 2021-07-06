package etsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.BrowserFactory;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class TC002_Mmsezgin {
    /*
    Test Case 002 : Clothing & Shoes
	1.Go to Etsy.com ( Chrome and Firefox only )
	2.Click on "Clothing & Shoes" product category title
	3.Select "1 business day" checkbox from under the "Ready to ship in" options on the left
	4.Verify that the checkbox is selected and current url contains "max_processing_days=1"
     */

    WebDriver driver;

    @AfterClass
    public void quit(){
        driver.quit();
    }

    @BeforeMethod
    public void setup(){ driver= BrowserFactory.getDriver("chrome"); }


    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void testcase002() throws InterruptedException{
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("catnav-primary-link-10923")).click();
        Thread.sleep(3000);


        // Using labels to locate, because checkbox failed to be clicked.
        driver.findElement(By.cssSelector("label[for='max-processing-days-1']")).click();

        Thread.sleep(3000);
        WebElement checkbox = driver.findElement(By.id("max-processing-days-1"));
        Assert.assertTrue(checkbox.isSelected(),"verify that 1 business day is selected");

        String Url = driver.getCurrentUrl();
        Assert.assertTrue(Url.contains("max_processing_days=1"), "verify that Url contains max_processing_days=1");


    }
}