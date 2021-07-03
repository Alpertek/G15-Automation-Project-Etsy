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

public class TC004_Sumeyse {
    /*Test Case 004 : Wedding & Party
	1.Go to Etsy.com ( Chrome and Firefox only )
	2.Click on "Wedding & Party" product category title
	3.Click the inputbox the placeholder text of which is "Low" under Price option on the right side
	4.Verify that "Custom" radio button is selected after inputbox is clicked*/

    WebDriver driver;

    @BeforeMethod
    public void setup(){ driver= BrowserFactory.getDriver("chrome"); }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("catnav-primary-link-10983")).click();
        driver.findElement(By.id("search-filter-min-price-input")).click();
        Thread.sleep(3000);

        WebElement RadioBtn = driver.findElement(By.id("price-input-custom"));
        Assert.assertTrue(RadioBtn.isSelected(),"verify that custom is selected");
        System.out.println("CustomBtn.isSelected() = " + RadioBtn.isSelected());
        Thread.sleep(3000);




    }

}