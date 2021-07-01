package etsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import utilities.BrowserFactory;

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
        //driver.quit();
    }

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void close(){
       
        //driver.close();
    }

    @Test
    public void TC009(){
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

    }
}
