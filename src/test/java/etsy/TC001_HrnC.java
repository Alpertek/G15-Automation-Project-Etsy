package etsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TC001_HrnC {

    /*
    Test Case 001 : Jewelry & Accessories
	1. Go to Etsy.com ( Chrome and Firefox only )
	2. Click on "Jewelry & Accessories" product category title
	3. Select "Free Shipping" checkbox from under the "Special offers" options on the left
	4. Verify that the checkbox is selected and current url contains "free_shipping=true"
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.etsy.com/");

        WebElement jevAndAccMenu = driver.findElement(By.id("catnav-primary-link-10855"));
        jevAndAccMenu.click();

        Thread.sleep(2000);

        //WebElement labelFreeShip = driver.findElement(By.xpath("//input[@name='free_shipping']"));
        WebElement labelFreeShip = driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));

        WebElement checkboxFreeShipping = driver.findElement(By.xpath("//input[@name='free_shipping']"));
        Assert.assertFalse(checkboxFreeShipping.isSelected(),"verify checkboxFreeShipping is NOT selected");

        //How to verify checkbox is selected or not?
        System.out.println("checkboxFreeShipping.isSelected() = " + checkboxFreeShipping.isSelected());

        //verify checkboxFreeShipping is selected
       //Assert.assertFalse(checkboxFreeShipping.isSelected(),"verify checkboxFreeShipping is selected");

        //how to check checkboxes?
        //just like a radio button, we use click() method
        //Thread.sleep(2000);
        labelFreeShip.click();

        Thread.sleep(2000);
        checkboxFreeShipping = driver.findElement(By.xpath("//input[@name='free_shipping']"));

        //verify after click
        Assert.assertTrue(checkboxFreeShipping.isSelected(),"verify checkboxFreeShipping is selected");

    }

}






