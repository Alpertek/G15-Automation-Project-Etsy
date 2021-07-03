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

import java.util.List;

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
    public void testcase005() throws InterruptedException {
    driver.get("https://www.etsy.com/");
    driver.findElement(By.cssSelector("#catnav-primary-link-11049")).click();
        //List<WebElement> color1 = driver.findElements(By.xpath("//input[@name='attr_1']"));
        //System.out.println("color1.size() = " + color1.size());

        WebElement element = driver.findElement(By.xpath("//label[@for='attr_1-4']"));
        Assert.assertFalse(element.isDisplayed());


    }
}
