package etsy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.Set;

public class TC006_UK {
    /*
    Test Case 006 : search white board
	1. Go to Etsy.com ( Chrome and Firefox only )
	2. Enter "white board" in the search box
	3. Click on the search button
	4. Click and open the first search result
	5. Click on "Add to cart" button
	6. Verify that there is "1 item in your cart".
	7. Remove product from cart by clicking on "Remove"
	8. Verify that the cart is empty
    */
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");

    }
    @AfterMethod
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void TestCase6() throws InterruptedException {
        driver.get("https://www.etsy.com");
        WebElement searchBox=driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBox.sendKeys("white board");

        WebElement searchButton=driver.findElement(By.cssSelector("span.etsy-icon.wt-nudge-b-1"));
        searchButton.click();
        WebElement firstresult=driver.findElement(By.xpath("(//div/div/h3)[1]"));
        firstresult.click();
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {

            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }
        WebElement chart= driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        chart.click();
        WebElement item=driver.findElement(By.xpath("(//h1[@class='wt-text-heading-01'])[1]"));
        Assert.assertTrue(item.getText().equals("1 item in your cart"),"Verify that there is 1 item in your cart");
        WebElement remove=driver.findElement(By.xpath("(//li/a/span)[10]"));
        remove.click();
        WebElement empty= driver.findElement(By.cssSelector("h1.wt-text-heading-01.wt-pt-xs-2.wt-pb-xs-2"));

        Assert.assertTrue(empty.getText().equals(""),"Verify your chart is empty");





    }



}
