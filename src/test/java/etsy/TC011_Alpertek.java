package etsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TC011_Alpertek {
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
    public void executeTc011() throws InterruptedException {
        this.driver.get("https://www.etsy.com");
        WebElement vintage = this.driver.findElement(By.cssSelector("a[href^='https://www.etsy.com/c/vintage']"));
        vintage.click();
        Thread.sleep(3000);
        WebElement shippingOptions = this.driver.findElement(By.id("ship_to_select"));
        Select selectShippingOptions = new Select(shippingOptions);
        selectShippingOptions.selectByVisibleText("China");
        Thread.sleep(3000);
        String expectedOption = "China";
        // To prevent an exception that says "element is not attached to the page document" :
        shippingOptions = this.driver.findElement(By.id("ship_to_select"));
        selectShippingOptions = new Select(shippingOptions);
        String actualOption = selectShippingOptions.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "Verify that 'China' is selected");
        boolean containsCN = this.driver.getCurrentUrl().contains("ship_to=CN");
        Assert.assertTrue(containsCN, "Verify that the current url contains 'ship_to=CN'");
    }
}
