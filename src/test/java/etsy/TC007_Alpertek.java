package etsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class TC007_Alpertek {
    WebDriver driver;
    @Test
    void testcase007() throws InterruptedException {
        //Test Case 007 : Arts & Collectibles
        //	1.Go to Etsy.com
        //	2.Click on "Art & Collectibles" category title
        //	3.Select "Europe" under Shop location options on the left side
        //	4.Verify that "Europe" is selected
        //	5.Click on the textbox and enter "Turkey"
        //	6.Click on ">" sign(arrow)
        //	7.Verify that "Turkey" option is selected
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        WebElement art_collectibles = driver.findElement(By.id("catnav-primary-link-66"));
        art_collectibles.click();
        WebElement europe = driver.findElement(By.id("shop-location-input-1"));
        Actions mouse = new Actions(driver);
        mouse.moveToElement(europe).click().perform();

        europe = driver.findElement(By.id("shop-location-input-1"));

        Assert.assertTrue(europe.isSelected(),"Verify that Europe is selected as shop location");
        WebElement customLocation = driver.findElement(By.id( "shop-location-input"));
        customLocation.sendKeys("Turkey");
        WebElement clickArrow = driver.findElement(By.cssSelector(".shop-location-submit"));
        clickArrow.click();
        WebElement turkey = driver.findElement(By.id("shop-location-input-custom-location"));
        Assert.assertTrue(turkey.isSelected(),"Verify that Turkey is selected as shop location");



    }
    @BeforeMethod
    void setup(){
        driver = BrowserFactory.getDriver("chrome");
    }
    @AfterMethod
    void close() throws InterruptedException {
        driver.close();
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
