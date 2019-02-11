package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class FrontPage {
    private WebDriver driver;

    public FrontPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitForAppear() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cookie-disclaimer-ui")));
    }

    public String goToHomePage() {
        return "https://www.epam.com/";
    }

    public void selectLocation(String location){
        WebElement selectRegionBtn = driver.findElement(By.cssSelector(".location-selector__button"));
        selectRegionBtn.click();

        WebElement regionDrp = driver.findElement(By.xpath("(//h2[contains(text(),'Select a region')])[1]"));
        Assert.assertEquals(true, regionDrp.isDisplayed());

        List<WebElement> locations = driver.findElements(By.cssSelector(".location-selector__link"));
        for (WebElement o : locations){
            if (o.getText().equals(location)){
                o.click();
                break;
            }
        }
    }
}
