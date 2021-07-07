package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    private BrowserFactory(){}
    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static WebDriver getDriver(String browserType) {

        WebDriver driver = null;

        boolean winXsafari = OS.contains("win") && browserType.equalsIgnoreCase("safari");
        boolean macXedge = OS.contains("mac") && browserType.equalsIgnoreCase("edge");

        if (winXsafari || macXedge) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;
        } else {
            switch (browserType.toLowerCase()) {
                case "chrome-noNotifications":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options=new ChromeOptions();
                    Map<String, Object> prefs=new HashMap<>();
                    prefs.put("profile.default_content_setting_values.notifications", 1);
                    //1-Allow, 2-Block, 0-default
                    options.setExperimentalOption("prefs",prefs);
                    driver=new ChromeDriver(options);
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
            }

        }
        return driver;
    }
}
