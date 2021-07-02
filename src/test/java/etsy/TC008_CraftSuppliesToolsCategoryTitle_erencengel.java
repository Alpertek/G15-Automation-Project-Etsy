package etsy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TC008_CraftSuppliesToolsCategoryTitle_erencengel {

    /*
    Test Case 008 : Craft Supplies & Tools
	1.Go to Etsy.com
	2.Click on "Craft Supplies & Tools" category title
	3.Click on "Paper, Party & Kids" subcategory on the left
	4.Verify that current url contains "craft-supplies-and-tools/paper-party-and-kids"
	5.Select "Baby shower" option under "Occasion" options
	6.Verify that it is selected
     */

    WebDriver driver;

    public static void main(String[] args) {

    }

    @BeforeMethod
    public void setDriver() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.etsy.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.cssSelector("#catnav-primary-link-562")).click();
        WebElement paperİcon = driver.findElement(By.xpath("//span[text()='Paper, Party & Kids ']"));
        paperİcon.click();
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        String Url = driver.getCurrentUrl();
        Assert.assertTrue(Url.contains("craft-supplies-and-tools/paper-party-and-kids"), "verify that Url contains craft-supplies-and-tools/paper-party-and-kids");
        Thread.sleep(3000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.cssSelector("#catnav-primary-link-562")).click();
        driver.findElement(By.xpath("//span[text()='Paper, Party & Kids ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='attr_3-13']")).click();
        Thread.sleep(3000);
        WebElement babyShower = driver.findElement(By.cssSelector("#attr_3-13"));
        Assert.assertTrue(babyShower.isSelected(),"verify that babyShower is selected");
        Thread.sleep(3000);
    }



}
