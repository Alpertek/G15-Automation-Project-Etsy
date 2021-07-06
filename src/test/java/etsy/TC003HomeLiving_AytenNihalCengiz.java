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

public class TC003HomeLiving_AytenNihalCengiz {

//Test Case 003 : Home & Living
//	1.Go to Etsy.com ( Chrome and Firefox only )
//	2.Click on "Home & Living" product category title
//	3.Sort results by "Lowest Price" by selecting from the dropdown ("Sort by: Relevancy") on the right side
//	4. Verify that visible text of the selected filter of the dropdown is "Sort by: Lowest Price" and url contains "order=price_asc"

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }


    @Test
    public void tc003() throws InterruptedException {
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        //driver.findElement(By.xpath("//*[@id='side-nav-category-link-891']")).click();
        driver.findElement(By.id("catnav-primary-link-891")).click();
        Thread.sleep(2000);

         WebElement element = driver.findElement(By.xpath("//span[@class='wt-menu__trigger__label']")).click();
        Thread.sleep(2000);

        Select order = new Select(element);
        order.selectByVisibleText("Sort by: Lowest Price");
        Thread.sleep(2000);

        String expedtedResult = "Sort by: Lowest Price";

        element = driver.findElement(By.xpath("//span[@class='wt-menu__trigger__label']"));
        order = new Select(element);
        String actualResult = order.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult,expedtedResult, "Verify that the order is 'Sort by: Lowest Price' ");
        boolean result = driver.getCurrentUrl().contains("order=price_asc");
        Assert.assertTrue(result, "Verify that the current url contains 'order=price_asc' ");
    }

    }

