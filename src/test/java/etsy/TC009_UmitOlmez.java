package etsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.BrowserFactory;

import java.util.Set;

import static org.testng.Assert.assertTrue;

/*
Test Case 009 : search sunglasses - Handmade
        1.Go to Etsy.com
        2.Enter "sunglasses" in the search box
        3.Click on "All Filters" on the left side
        4.Click on "Handmade" option under Item type title
        5.Click on "Apply" button
        6.Click and open the first product which is on the top-left, among results
        7.Verify that "Handmade" expression is available under Highlights mini-title in the product detail page
*/
public class TC009_UmitOlmez {
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
    public void TC009() throws InterruptedException{
        //1.Go to Etsy.com
        driver.get("https://www.etsy.com");
        //2.Enter "sunglasses" in the search box
        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("sunglasses");
        WebElement searchButton = driver.findElement(By.xpath("//button[@value='Search']"));
        searchButton.click();
        //3.Click on "All Filters" on the left side
        WebElement allFilters = driver.findElement(By.cssSelector("#search-filter-button"));
        allFilters.click();
        //4.Click on "Handmade" option under Item type title
        WebElement handmade = driver.findElement(By.xpath("//label[@for='item-type-input-1']"));
        handmade.click();
        //5.Click on "Apply" button
        WebElement apply = driver.findElement(By.xpath("//button[@*='Apply']"));
        apply.click();

        //wait for uploading the result
        Thread.sleep(4000);

        //6.Click and open the first product which is on the top-left, among results
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@data-listing-id='955159345']/div)[2]/div/h3"));
        firstProduct.click();

        //switching to the new tab
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {

            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }

        //7.Verify that "Handmade" expression is available under Highlights mini-title in the product detail page
        WebElement handmade2 = driver.findElement(By.xpath("//div[@class='wt-ml-xs-2']"));
        String actualResult = handmade2.getText();
        Assert.assertTrue(actualResult.equals("Handmade"), "Verify that \"Handmade\" available");
    }
}
