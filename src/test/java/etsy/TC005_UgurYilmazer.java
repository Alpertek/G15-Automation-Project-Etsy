package etsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TC005_UgurYilmazer {

    WebDriver driver;

    @AfterClass
    public void quit(){
        driver.quit();
    }

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void close(){
        driver.close();
    }

    @Test
    public void testcase005() throws InterruptedException {
        driver.get("https://www.etsy.com");
        driver.findElement(By.cssSelector("#catnav-primary-link-11049")).click();
        WebElement element = driver.findElement(By.xpath("//label[@for='attr_1-4']"));
        Assert.assertFalse(element.isDisplayed());
        driver.findElement(By.xpath("//button[@aria-label='Show more']")).click();
        WebElement element1 = driver.findElement(By.xpath("//label[@for='attr_1-4']"));
        Assert.assertTrue(element1.isDisplayed());
        driver.findElement(By.xpath("//label[@for='attr_1-4']")).click();
        Thread.sleep(2000L);
        WebElement element2 = driver.findElement(By.id("attr_1-4"));
        System.out.println("element2.isSelected() = " + element2.isSelected());
        Assert.assertTrue(element2.isSelected());
    }
}
