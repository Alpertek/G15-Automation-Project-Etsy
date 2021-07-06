package etsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

    @AfterMethod
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

        driver.findElement(By.xpath("//span[contains(text(),'Sort by: Relevancy')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Lowest Price')]")).click();
        Thread.sleep(2000);

        String expectedResult = "Sort by: Lowest Price";
        String visibleText = driver.findElement(By.xpath("//span[text()='Sort by: Lowest Price']")).getText();

        Assert.assertTrue(visibleText.equals(expectedResult), "Visible Text Verified!");

        String currentUrl = driver.getCurrentUrl();
        String expectedInUrl = "order=price_asc";

        Assert.assertTrue(currentUrl.contains(expectedInUrl), "URL contains expectedInUrl");

    }

}

