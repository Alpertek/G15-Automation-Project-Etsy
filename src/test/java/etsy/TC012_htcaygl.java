package etsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TC012_htcaygl {

        WebDriver driver;

        @BeforeMethod
        public void setup(){ driver= BrowserFactory.getDriver("chrome"); }

        @AfterMethod
        public void teardown() throws InterruptedException {
            Thread.sleep(2000);
            driver.quit();
        }

        @Test
        public void test1() throws InterruptedException {

        /*Test Case 012:
	1.Go to Etsy.com
	2.Search for "living room furniture"
	3.Click on "All Filters" on the left side
	3.Select "Can be gift-wrapped" and "Customizable" options under "Ordering options"
	4.Click on "Apply" button
	5.Verify that "Can be gift-wrapped X" and "Customizable X" are there below "All Filters" label
*/

            driver.get("https://www.etsy.com/");
            driver.manage().window().maximize();

            driver.findElement(By.id("global-enhancements-search-query")).sendKeys("living room furniture");

            driver.findElement(By.xpath("//button[@class='wt-input-btn-group__btn global-enhancements-search-input-btn-group__btn']")).click();

            // 3.Click on "All Filters" on the left side
            driver.findElement(By.id("search-filter-button")).click();


            // driver.findElement(By.id("gift-wrap")).click();

            Thread.sleep(2000);  // It is needed for click 'gift-wrap' element

            // These were added with the help of Stackoverflow website.
            Actions actions1 = new Actions(driver);
            actions1.moveToElement(driver.findElement(By.id("gift-wrap"))).click().build().perform() ;
            actions1.moveToElement(driver.findElement(By.id("customizable"))).click().build().perform() ;


            //driver.findElement(By.id("customizable")).click();

            driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']")).click();

            // Thread.sleep(2000);

            //   driver.findElement(By.xpath("//a[@aria-label='Remove Can be gift-wrapped Filter']")).click();
            //  driver.findElement(By.xpath("(//a[@class='wt-btn wt-action-group__item wt-btn--small wt-display-flex-xs wt-align-items-center'])[1]")).click();

            Thread.sleep(2000);

        }
}


