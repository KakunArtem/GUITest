package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JobListingsPage {
    private WebDriver driver;

    public JobListingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitForAppear() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".selected-items")));
    }

    public void checkChosenCriteria(String jobType, String location) {
        WebElement selectedItems = driver.findElement(By.xpath("//ul[@class='selected-items']/li[contains(text(), '')]"));          //переделать, чтобы искало матчи
        Assert.assertEquals(selectedItems.getText(), jobType.toUpperCase());

        WebElement selectedLocation = driver.findElement(By.xpath("(//header/strong)[1]"));
        Assert.assertEquals(selectedLocation.getText(), location.toUpperCase());
    }

    public void clickApplyBtn(String button, int option) {
        List<WebElement> buttons = driver.findElements(By.xpath("//a[@class='search-result__item-apply' and contains(text(),'Apply')]"));
        for (WebElement o : buttons) {
            if (option > 0 && option <= buttons.size() && o.getText().equals(button.toUpperCase())) {
                buttons.get(option - 1).click();
                break;
            } else {
                throw new NotFoundException("option " + option + " not found");
            }
        }
    }
}

