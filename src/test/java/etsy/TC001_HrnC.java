package etsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

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
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.etsy.com/");

        WebElement jevAndAccMenu = driver.findElement(By.id("catnav-primary-link-10855"));
        jevAndAccMenu.click();

        Thread.sleep(2000);

        //WebElement checkBoxFreeShip = driver.findElement(By.xpath("//input[@name='free_shipping']"));
        WebElement checkBoxFreeShip = driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));


        //How to verify checkbox is selected or not?
       //System.out.println("checkBoxFreeShip.isSelected() = " + checkBoxFreeShip.isSelected());

        //verify checkBoxFreeShip is selected
       //Assert.assertTrue(checkBoxFreeShip.isSelected(),"verify checkBoxFreeShip is selected");

        //how to check checkboxes?
        //just like a radio button, we use click() method
        //Thread.sleep(2000);
        checkBoxFreeShip.click();

        //verify after click
        Assert.assertTrue(checkBoxFreeShip.isSelected(),"verify checkBoxFreeShip is selected");

    }

}






