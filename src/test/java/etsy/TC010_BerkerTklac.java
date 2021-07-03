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

import java.util.List;
/*
 1.Go to "https://www.etsy.com/listing/955159345/retro-rectangle-vintage-sunglasses"
         2.Click on "Add to cart" button
         3.Verify that the warning message "Please select a color" is visible above "Add to cart" button
         4.Select "Black" from Primary Color options
         5.Verify that "Black" is selected
         6.Click on "Add to cart" button
         7.Verify that current url starts with "https://www.etsy.com/cart/?show_cart"
*/

public class TC010_BerkerTklac {
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
    public void tc010() throws InterruptedException {

        driver.get("https://www.etsy.com/listing/955159345/retro-rectangle-vintage-sunglasses");

        WebElement addToCard = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-width-full']/div[contains(.,'Add to cart')]"));

        addToCard.click();

        WebElement warningMessage = driver.findElement(By.xpath("//div[@class='wt-validation__message']"));

        String actualText= warningMessage.getText();

        Assert.assertTrue(actualText.equals("Please select a color"));

        Thread.sleep(5000);

        WebElement selectColor = driver.findElement(By.xpath("//select[@id='inventory-variation-select-0']"));

        Select color = new Select(selectColor);

        String expectedResult = "Black";

        System.out.println("expectedResult = " + expectedResult);

        color.selectByIndex(1);

        String actualResult = color.getFirstSelectedOption().getText();

        System.out.println("actualResult = " + actualResult);

        Assert.assertEquals(expectedResult,actualResult,"verify that black is selected");

        Thread.sleep(3000);

        WebElement clickAdd = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-width-full']/div[contains(.,'Add to cart')]"));

        clickAdd.click();

        Thread.sleep(3000);

        String expectedUrl = "https://www.etsy.com/cart/?show_cart";

        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.startsWith(expectedUrl),"verify that url start with actual url");



    }
}
