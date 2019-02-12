package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserDriver {
    public static WebDriver driver = new ChromeDriver();

    public static void browserSetUp() {
//        System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("chromedriver"));
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(99, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
    }

    public static void close() {
        driver.quit();
    }

    public static void loadPage(String url) {
        driver.get(url);
    }
}
